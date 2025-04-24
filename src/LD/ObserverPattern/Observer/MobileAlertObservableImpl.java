package LD.ObserverPattern.Observer;

import LD.ObserverPattern.Observable.StocksObservable;

public class MobileAlertObservableImpl implements NotificationAlertObserver{

    String userName;

    StocksObservable observable;

    public MobileAlertObservableImpl(String userName, StocksObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendMsgOnMobile(userName, "Stocks are available now");
    }

    private void sendMsgOnMobile(String userName, String message) {
        System.out.println("Message sent to "+userName+" with message "+message);
    }
}
