https://www.youtube.com/watch?v=Ep9_Zcgst3U&t=665s

>This is a behavioral pattern

Use Case : Amazon has a site where we are supposed to implement the following functionality 

* product goes out of stock and we have to implement a **"notify me"** scenario for the END-USER.


Structure for following an Observer Pattern 

* ObservableInterface  : which means thing or detail are we trying to observe !??
	* ObservableInterface Concrete Class

* ObserverInterface : which means Consumers for the observer !?
	* ObserverInterface Concrete Class


Example : 
* WeatherStationObservable 
	* Weather
* WeatherObserver
	* TelevisionObserverImpl
	* AndroidObserverImpl

Now for the above problem statement 
Example : 
* StocksObservable 
	* IphoneObservableImpl (Concrete Class)
* NotificationObserver
	* EmailAlertObserverImpl (Concrete Class)
	* MobileAlertObserverImpl (Concrete Class)
