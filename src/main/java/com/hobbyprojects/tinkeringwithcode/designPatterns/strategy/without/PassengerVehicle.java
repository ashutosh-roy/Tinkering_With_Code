package com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.without;

public class PassengerVehicle extends Vehicle {
  @Override
  public void drive() {
    System.out.println("Driving a passenger vehicle");
  }
}
