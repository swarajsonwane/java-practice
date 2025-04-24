package LD.logger;

public class InfoLogProcessor extends LogProcessor{


    // This processor will only process the logs with INFO level
    // If the log level is not INFO, it will pass it to the next processor
    //so below constuctor will pass the next processor to the super class constructor
    // if this processor comes before the next in the chain of responsibility
    // eg. if the chain is  InfoLogProcessor -> DebugLogProcessor -> ErrorLogProcessor
    InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

     public void log(int logLevel , String message) {
         if (logLevel == INFO) {
             System.out.println("INFO: " + message);
         } else {
             super.log(logLevel, message);
         }

     }

}
