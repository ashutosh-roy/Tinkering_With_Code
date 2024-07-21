package com.hobbyprojects.tinkeringwithcode.service;
/**
 * ```
 * In Java, things are strictly Pass By Value
 * (for objects, Pass BY VALUE occurs and it means that REFERENCE is passed as VALUE.)
 *
 * Pass By Reference :
 * Scenario --- If teacher has given his original class notes doc to a student,
 * any changes he makes there will reflect in others who have the sheet.
 *
 * Pass By Value :
 * Scenario --- If teacher has given his printout of Original class notes doc to a student,
 * any changes he makes there will reflect in others who have the sheet.
 *
 *
 * Pass By Reference, happens in C with the help of pointers.
 *
 * ```*/
public class PassByExample {

    String name = "";

    PassByExample(String name)
    {
        this.name = name;
    }

    static void updateName(PassByExample passByReference)
    {
        passByReference.name = "\n In Java, things are strictly Pass By Value. \n Pass By Reference actually means Pass The Reference as a value";
    }
    String getName()
    {
        return this.name;
    }

    public static void main(String[] args) {
        int a =12 ;
        changePrimitives(a);
        System.out.println("OP :- "+a);
        PassByExample passByReference = new PassByExample("Pass By Reference");
        System.out.println("OP :- "+passByReference.getName());
        updateName(passByReference);
        System.out.println("After update :- "+passByReference.getName());
    }

    private static void changePrimitives(int a) {
        a =122;
    }
}
