package com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with;

public class StrategyMain {
  public static void main(String[] args) {
    Vehicle sportsVehicle = new SportsCar();
    sportsVehicle.getVehicleDetails();

    Vehicle suv = new OffroadVehicle();
    suv.getVehicleDetails();
  }
}
