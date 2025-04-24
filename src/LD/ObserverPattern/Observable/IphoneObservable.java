package LD.ObserverPattern.Observable;

import LD.ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StocksObservable{
    private int stockCount;
    private List<NotificationAlertObserver> observers;

    public IphoneObservable() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void add(NotificationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stockCount ==0) {
            System.out.println("New stock added"+ newStockAdded);
            notifyObservers();
        }
        stockCount = stockCount+newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
