//package src.main.java.org.example.lesson10.loggingTask;

/*
Я вирішив не додавати в FileLoggerConfiguration такий параметр як "формат",
можливо я не зрозумів його призначення, вважаю його зайвим.
 */
public class LogMain {
    public static void main(String[] args) throws InterruptedException {
        FileLoggerConfigurationLoader confLoader = new FileLoggerConfigurationLoader();
        confLoader.load("src/main/java/org/example/lesson10/loggingTask/ConfigurationFiles/Config1");
       FileLogger fileLogger = new FileLogger(confLoader.load("src/main/java/org/example/lesson10/loggingTask/ConfigurationFiles/Config1"));
        fileLogger.info("Program start");
        fileLogger.debug("Program still work");

        while(true){
            Thread.sleep(1000);
            fileLogger.info("Program loop...");
        }
    }
}
