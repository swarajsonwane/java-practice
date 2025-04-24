package LD.ObserverPattern;

import LD.ObserverPattern.Observable.IphoneObservable;
import LD.ObserverPattern.Observable.StocksObservable;
import LD.ObserverPattern.Observer.EmailAlertObserverImpl;
import LD.ObserverPattern.Observer.MobileAlertObservableImpl;
import LD.ObserverPattern.Observer.NotificationAlertObserver;

public class Store {


    public static void main(String[] args) {
        StocksObservable iphoneObservable = new IphoneObservable();
        NotificationAlertObserver emailObserver = new EmailAlertObserverImpl("abc@gmail.com",iphoneObservable );
        NotificationAlertObserver emailObserver2 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneObservable);
        NotificationAlertObserver mobileObserver = new MobileAlertObservableImpl("abc", iphoneObservable);

        iphoneObservable.add(emailObserver);

        iphoneObservable.add(emailObserver2);
        iphoneObservable.add(mobileObserver);

        System.out.println(iphoneObservable.getStockCount());
        // This will notify all observers when stock is added
        iphoneObservable.setStockCount(10);

        //this will not notify users again as stock is more than 0
        iphoneObservable.setStockCount(100);

        // you have to reset stock count to 0 to notify users again
        iphoneObservable.setStockCount(0);

        iphoneObservable.setStockCount(5);
    }
}
