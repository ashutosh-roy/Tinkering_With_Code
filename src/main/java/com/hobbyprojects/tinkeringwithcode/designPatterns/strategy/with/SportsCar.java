package com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with;

import com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with.driveStrategy.VTwelveDrivingStrategy;
import com.hobbyprojects.tinkeringwithcode.designPatterns.strategy.with.seatingStrategy.CoupeStrategy;

public class SportsCar extends Vehicle {

  SportsCar() {
    super(new VTwelveDrivingStrategy(), new CoupeStrategy());
  }
}
