package com.hobbyprojects.tinkeringwithcode.designPatterns.decorator;

//is-a Relationship
public class Farmhouse extends BasePizza {

    @Override
    public int cost() {
        System.out.print("\tFarmhouse Cost : 120");
        return 100;
    }
}
