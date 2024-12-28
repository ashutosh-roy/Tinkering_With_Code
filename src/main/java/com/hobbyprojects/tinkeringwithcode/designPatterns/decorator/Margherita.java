package com.hobbyprojects.tinkeringwithcode.designPatterns.decorator;

//is-a Relationship
public class Margherita extends BasePizza {
    @Override
    public int cost() {
        System.out.print("\tMargherita Cost : 120");
        return 120;
    }
}
