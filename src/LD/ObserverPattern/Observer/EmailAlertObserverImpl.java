package LD.ObserverPattern.Observer;

import LD.ObserverPattern.Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;

    StocksObservable observable;

    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendMail(emailId, "Stocks are available now");
    }

    private void sendMail(String emailId, String message) {
        System.out.println("Email sent to "+emailId+" with message "+message);
    }
}
