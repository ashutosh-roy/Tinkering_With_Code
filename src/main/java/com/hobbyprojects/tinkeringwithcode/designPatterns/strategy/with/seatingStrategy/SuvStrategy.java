package com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with.seatingStrategy;

public class SuvStrategy implements SeatingStrategy {

  @Override
  public void displayNumberOfSeats() {
    System.out.println("7 seater Car");
  }
}
