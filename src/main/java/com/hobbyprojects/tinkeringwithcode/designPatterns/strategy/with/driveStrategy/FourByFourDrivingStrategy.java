package com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with.driveStrategy;

public class FourByFourDrivingStrategy implements DrivingStrategy {
    @Override
    public void drive() {
        System.out.println("Load Configuration for an OffRoad Vehicle");
    }
}
