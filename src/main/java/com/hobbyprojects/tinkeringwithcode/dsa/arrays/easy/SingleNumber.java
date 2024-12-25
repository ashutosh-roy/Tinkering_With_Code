package com.hobbyprojects.tinkeringwithcode.dsa.arrays.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleNumber {

  public static void main(String[] args) {
    int[] ar = new int[] {1, 2, 2, 4, 1, 5, 5};
    log.info("Single Number :- %s".formatted(findSingleNumber(ar)));
    log.info("Single Number With Clean Code :- %s".formatted(findSingleNumberCleanCode(ar)));
    log.info("Single Number using XOR :- %s".formatted(findSingleNumberUsingXOR(ar)));
  }

  public static int findSingleNumberUsingXOR(int[] ar) {
    int singleNumber = 0;
    for (int i : ar) {
      singleNumber = singleNumber ^ i;
    }
    return singleNumber;
  }

  public static int findSingleNumberCleanCode(int[] ar) {
    AtomicInteger singleNumber = new AtomicInteger();
    Map<Integer, Integer> elementsWithFrequency = new HashMap<>();
    for (int j : ar) {
      elementsWithFrequency.putIfAbsent(j, 0);
      elementsWithFrequency.computeIfPresent(j, (key, value) -> ++value);
    }
    elementsWithFrequency.forEach(
        (key, value) -> {
          if (value == 1) {
            singleNumber.set(key);
          }
        });
    return singleNumber.get();
  }

  public static int findSingleNumber(int[] ar) {
    AtomicInteger singleNumber = new AtomicInteger();
    Map<Integer, Integer> elementsWithFrequency = new HashMap<>();
    for (int i = 0; i < ar.length; i++) {
      if (elementsWithFrequency.containsKey(ar[i])) {
        int count = elementsWithFrequency.get(ar[i]);
        elementsWithFrequency.put(ar[i], ++count);
      } else {
        elementsWithFrequency.put(ar[i], 1);
      }
    }
    elementsWithFrequency
        .entrySet()
        .forEach(
            entry -> {
              if (entry.getValue() == 1) {
                singleNumber.set(entry.getKey());
              }
            });
    return singleNumber.get();
  }
}
