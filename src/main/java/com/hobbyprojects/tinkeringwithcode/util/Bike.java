package com.hobbyprojects.tinkeringwithcode.util;

import java.util.Iterator;
import java.util.List;
/**
 * Why learn example of inner class ? Java 8 has lambda functions which use
 * ___Two types of inner classes :
 * Local
 * Anonymous
 * ___Lambda expressions use some version of anonymous classes.
 * Why learn lambda ? It was introduced in Java 8.
 * @link-referred : https://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html
 */
public class Bike {

    List<String> models;

    Bike()
    {
        models = List.of("KTM ADV 250", "KTM ADV 390", "KTM ADV 390 X");
    }
    public void displayModel()
    {
        EventIterator eventIterator = this.new EventIterator();
        while(eventIterator.hasNext())
        {
            System.out.print(eventIterator.next()+" ");
        }
    }
    interface BikeIterator extends Iterator<String> {};

    class EventIterator implements BikeIterator
    {
        int nextIndex = 0;
        @Override
        public boolean hasNext() {
            return nextIndex < models.size();
        }

        @Override
        public String next() {
            return models.get(nextIndex++);
        }
    }
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.displayModel();
    }
}
