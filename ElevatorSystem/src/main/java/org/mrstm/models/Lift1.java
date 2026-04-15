package org.mrstm.models;

public class Lift1 implements Elevator {
    @Override
    public void open() {
        System.out.println("Opening Elevator 1...");
    }

    @Override
    public void close() {
        System.out.println("Closing Elevator 1...");
    }

    @Override
    public void moveUp() {
        System.out.println("Elevator 1 moving up...");
    }

    @Override
    public void moveDown() {
        System.out.println("Elevator 1 moving down...");
    }
}
