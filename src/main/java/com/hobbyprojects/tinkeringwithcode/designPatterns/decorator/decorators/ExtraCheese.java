package com.hobbyprojects.tinkeringwithcode.designPatterns.decorator.decorators;

import com.hobbyprojects.tinkeringwithcode.designPatterns.decorator.BasePizza;
// is-a relationship with ToppingDecorator
// has-a relationship with BasePizza object
public class ExtraCheese extends ToppingDecorator {

    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        System.out.println("\tExtra Cheese cost : 10");
        return this.basePizza.cost() + 10;
    }
}
