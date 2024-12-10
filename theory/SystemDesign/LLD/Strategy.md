## Strategy Design Pattern 
![img_1.png](img_1.png)
Vehicle Class :
drive()
display() 
seatingCapacity() 

In the above diagram, there are 3 vehicle (child classes) inheriting from the parent Vehicle class. 

* Sporty Vehicle : 
    * drive() : can use a special type of engine
    * display() : can have an analog display 
    * seatingCapacity() : can be a 4 seater  

* OffRoad vehicle : can use a special type of engine
    * drive() : can use a special type of engine
    * display() : can have an analog display 
    * seatingCapacity() : can be a 4 seater 

* Passenger vehicle : uses a normal engine 
    * drive() : can use a special type of engine
    * display() : can have an digital display
    * seatingCapacity() : can be a 4 seater

On observing closely, we find that there's a lot of repeated code between Sporty vehicle and Offroad vehicle.


_____

