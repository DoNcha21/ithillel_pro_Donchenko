//package src.main.java.org.example.lesson10.loggingTask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger{
    FileLoggerConfiguration config;
    File file ;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void debug(String message){
//        System.out.println("===DEBUG===");
        if(config.logLevel == LoggingLevel.DEBUG){
            log(message);
        }
    }

    public void info(String message){
//        System.out.println("===INFO===");
        log(message);
    }

    private void log(String message){
//        System.out.println("===LOG===");
        SimpleDateFormat datePattern = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String currentDate = datePattern.format(new Date());
        this.checkFileSize(message);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("[" + currentDate + "]" + config.logLevel.name() + " : " + message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkFileSize(String message){
        if(file == null || !file.exists() || file.length() > config.maxFileSize + message.length()){
            SimpleDateFormat datePattern = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
            String currentDate = datePattern.format(new Date());
            file = new File("src/main/java/org/example/lesson10/loggingTask/LoggingFiles/logFile"  + currentDate + ".txt");
        }
    }
}