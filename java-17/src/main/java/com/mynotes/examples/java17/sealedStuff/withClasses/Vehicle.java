package com.mynotes.examples.java17.sealedStuff.withClasses;

public abstract sealed class Vehicle permits Car, Motorcycle {

    private String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

}
