package LD.logger;

public abstract class LogProcessor{

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    // This is the next processor in the chain of responsibility
    // If this processor is not able to handle the log, it will pass it to the next processor

    LogProcessor nextLogProcessor;

    LogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(int logLevel , String message){
        if(this.nextLogProcessor != null){
            this.nextLogProcessor.log(logLevel, message);
        }
    }
}
