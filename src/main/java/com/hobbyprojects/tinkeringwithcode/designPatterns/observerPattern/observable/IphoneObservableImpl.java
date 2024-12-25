package com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern.observable;

import com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern.observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObservable {
    List<NotificationObserver> observers = new ArrayList<>();
    int stockCount = 0;
    @Override
    public void add(NotificationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(NotificationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void sendNotification() {
        observers.forEach(observer -> {
            System.out.println("Notifying Observers!!");
            observer.update();
        });
    }

    @Override
    public void update() {
        sendNotification();
    }

    @Override
    public void setData(int data) {
        stockCount += data;
    }

    @Override
    public int getData() {
        return stockCount;
    }
}
