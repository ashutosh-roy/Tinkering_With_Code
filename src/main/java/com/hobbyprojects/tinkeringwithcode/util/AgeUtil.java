package com.hobbyprojects.tinkeringwithcode.util;

import java.util.function.Predicate;

public class AgeUtil {

  public static boolean isLegalToDrinkFor(int givenAge) {
    Predicate<Integer> isLegalToDrinkForAge = age -> age > 21;
    return isLegalToDrinkForAge.test(givenAge);
  }

  public static boolean isAdult(int givenAge) {
    Predicate<Integer> isAdult = age -> age > 18;
    return isAdult.test(givenAge);
  }
}
