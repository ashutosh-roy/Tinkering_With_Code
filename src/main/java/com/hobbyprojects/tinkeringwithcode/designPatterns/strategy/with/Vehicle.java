package com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with;

import com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with.driveStrategy.DrivingStrategy;
import com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with.seatingStrategy.SeatingStrategy;

public class Vehicle {
    DrivingStrategy drivingStrategy;
    SeatingStrategy seatingStrategy;

    Vehicle(DrivingStrategy drivingStrategy, SeatingStrategy seatingStrategy) {
        this.drivingStrategy = drivingStrategy;
        this.seatingStrategy = seatingStrategy;
    }
    void getVehicleDetails() {
        drivingStrategy.drive();
        seatingStrategy.displayNumberOfSeats();
    }
}
