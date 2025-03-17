//package src.main.java.org.example.lesson10.loggingTask;

import java.io.*;

class FileLoggerConfigurationLoader{

    public FileLoggerConfiguration load(String confFilePath){
        String filePath = "empty";
        LoggingLevel loggingLevel = null;
        int fileSize = -1;
        File file = new File(confFilePath);
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
//                System.out.println(line);
                String[] parts = line.split(":",2);
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch(key){
                    case "FILE_PATH":
                        filePath = value;
                        break;
                    case "LEVEL":
                        loggingLevel = LoggingLevel.valueOf(value);
                        break;
                    case "FILE_SIZE":
                        fileSize = Integer.parseInt(value);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(!filePath.equals("empty") && loggingLevel!=null && fileSize>0){
            return new FileLoggerConfiguration(filePath, loggingLevel, fileSize);//true
        }else {
            throw new RuntimeException("Invalid configuration file");//false
        }
    }

}