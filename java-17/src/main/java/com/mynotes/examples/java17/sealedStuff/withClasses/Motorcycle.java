package com.mynotes.examples.java17.sealedStuff.withClasses;

//Must specify modifier. Here `final` meaning, its not open for any further extension
public final class Motorcycle extends Vehicle{

    private final int numberOfSeats;

    public Motorcycle(int numberOfSeats, String registrationNumber) {
        super(registrationNumber);
        this.numberOfSeats= numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
