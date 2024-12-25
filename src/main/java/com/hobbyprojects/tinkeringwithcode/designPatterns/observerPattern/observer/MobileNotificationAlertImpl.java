package com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern.observer;

import com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern.observable.StocksObservable;

public class MobileNotificationAlertImpl implements NotificationObserver {
    String username;
    StocksObservable stocks;

    public MobileNotificationAlertImpl(final StocksObservable stocks, final String username) {
        this.stocks = stocks;
        this.username = username;
    }
    public void update() {
        System.out.println("\tNotification sent to user : "+username+"\n\tMessage: IPhone Stock : "+ stocks.getData());
    }
}
