package com.hobbyprojects.tinkeringwithcode.dsa.stack;

public interface Crud {
    public void push(int element);
    public void pop(int element);
    public void popGivenIndex(int index);
    public void pop();
    public void printContents();

}
