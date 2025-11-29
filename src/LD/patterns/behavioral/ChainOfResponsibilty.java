package LD.patterns.behavioral;

enum QueryType {
    TECHNICAL, BILLING, GENERAL
}

abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(QueryType queryType, String message);
}

class TechnicalSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(QueryType queryType, String message) {
        if (queryType == QueryType.TECHNICAL) {
            System.out.println("Technical Support: Handling query - " + message);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(queryType, message);
        }
    }
}

class BillingSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(QueryType queryType, String message) {
        if (queryType == QueryType.BILLING) {
            System.out.println("Billing Support: Handling query - " + message);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(queryType, message);
        }
    }
}

class GeneralSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(QueryType queryType, String message) {
        if (queryType == QueryType.GENERAL) {
            System.out.println("General Support: Handling query - " + message);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(queryType, message);
        }
    }
}

public class ChainOfResponsibilty {
    public static void main(String[] args) {
        TechnicalSupportHandler technicalSupport = new TechnicalSupportHandler();
        BillingSupportHandler billingSupport = new BillingSupportHandler();
        GeneralSupportHandler generalSupport = new GeneralSupportHandler();

        technicalSupport.setNextHandler(billingSupport);
        billingSupport.setNextHandler(generalSupport);

        technicalSupport.handleRequest(QueryType.TECHNICAL, "I can't connect to the internet.");
        technicalSupport.handleRequest(QueryType.BILLING, "I have a question about my invoice.");
        technicalSupport.handleRequest(QueryType.GENERAL, "Thank you for your service.");
    }
}

