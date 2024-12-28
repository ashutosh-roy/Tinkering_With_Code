package com.hobbyprojects.tinkeringwithcode.designPatterns.decorator.decorators;

import com.hobbyprojects.tinkeringwithcode.designPatterns.decorator.BasePizza;

public class Mushroom extends ToppingDecorator {

    BasePizza basePizza;

    public Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        System.out.println("\tMushroom cost : 20");
        return this.basePizza.cost() + 20;
    }
}
