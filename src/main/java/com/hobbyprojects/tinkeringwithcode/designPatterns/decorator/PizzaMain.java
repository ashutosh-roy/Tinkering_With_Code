package com.hobbyprojects.tinkeringwithcode.designPatterns.decorator;

import com.hobbyprojects.tinkeringwithcode.designPatterns.decorator.decorators.ExtraCheese;
import com.hobbyprojects.tinkeringwithcode.designPatterns.decorator.decorators.Mushroom;

public class PizzaMain {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese(new Margherita());
        System.out.println("\n\tMargherita with extra cheese : "+pizza.cost());
        BasePizza pizza1 = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println("\n\tMargherita with extra cheese and mushroom: "+pizza1.cost());
    }

}
