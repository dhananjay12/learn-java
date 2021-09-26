package com.mynotes.examples.java17.sealedStuff.withClasses;

//Must specify modifier. Here non-sealed meaning, its open for any further extension
public non-sealed class Car extends Vehicle{

    private final int numberOfSeats;

    public Car(int numberOfSeats, String registrationNumber) {
        super(registrationNumber);
        this.numberOfSeats= numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
