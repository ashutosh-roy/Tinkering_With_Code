package com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with.seatingStrategy;

public class CoupeStrategy implements SeatingStrategy {
    @Override
    public void displayNumberOfSeats() {
        System.out.println("2 Seater Coupe");
    }
}
