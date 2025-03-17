//package src.main.java.org.example.lesson10.loggingTask;

import java.text.SimpleDateFormat;
import java.util.Date;

class FileLoggerConfiguration{

    String filePath;
    LoggingLevel logLevel;
    int maxFileSize;

    public FileLoggerConfiguration(String filePath, LoggingLevel logLevel, int maxFileSize) {
        this.filePath = filePath;
        this.logLevel = logLevel;
        this.maxFileSize = maxFileSize;
    }

    public FileLoggerConfiguration(LoggingLevel logLevel, int maxFileSize) {
        SimpleDateFormat datePattern = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String currentDate = datePattern.format(new Date());
        this.filePath = "src/main/java/org/example/lesson10/loggingTask/LoggingFiles/logFile"  + currentDate + ".txt";
        this.logLevel = logLevel;
        this.maxFileSize = maxFileSize;
    }


}