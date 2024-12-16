package com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with;

import com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with.driveStrategy.FourByFourDrivingStrategy;
import com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with.seatingStrategy.SuvStrategy;

public class OffroadVehicle extends Vehicle {

    OffroadVehicle() {
        super(new FourByFourDrivingStrategy(), new SuvStrategy());
    }
}
