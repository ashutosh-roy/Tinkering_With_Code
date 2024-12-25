package com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern;

import com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern.observable.IphoneObservableImpl;
import com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern.observable.StocksObservable;
import com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern.observer.MobileNotificationAlertImpl;
import com.hobbyprojects.tinkeringwithcode.designPatterns.observerPattern.observer.NotificationObserver;

public class Store {
    public static void main(String[] args) {
        StocksObservable stocks = new IphoneObservableImpl();
        NotificationObserver notification = new MobileNotificationAlertImpl(stocks, "Ashutosh");
        // Add observers to notify!
        stocks.add(notification);

        //1.1 Update Stock Count
        stocks.setData(1);

        //1.2 Notify the observers
        stocks.update();

        //2.1 Update Stock Count
        stocks.setData(1);

        //2.2 Notify the observers
        stocks.update();
    }
}
