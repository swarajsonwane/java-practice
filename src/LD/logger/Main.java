package LD.logger;

public class Main {

    // This is chain of responsibility pattern
    // We have a chain of log processors
    // Each processor will process the log if it is able to handle it
    // if it is not able to handle it, it will pass it to the next processor in the chain
    //eg. if the chain is  InfoLogProcessor -> DebugLogProcessor -> ErrorLogProcessor
    // if the log level is INFO, it will be processed by InfoLogProcessor and so on
    public static void main(String[] args) {
        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logObject.log(LogProcessor.DEBUG, "This is a debug message");
        logObject.log(LogProcessor.ERROR, "This is an error message");
        logObject.log(LogProcessor.INFO, "This is an info message");
    }
}
