package com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern.observable;

import com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern.observer.NotificationObserver;

public interface StocksObservable {
    void add(NotificationObserver observer);
    void remove(NotificationObserver observer);
    void sendNotification();
    void update();
    void setData(int data);
    int getData();
}
