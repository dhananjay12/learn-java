package com.mynotes.examples.java17.sealedStuff.withRecords;

//Since records are implicitly final, the sealed hierarchy is even more concise.
// Extends is not allowed with records

public record Car(int numberOfSeats, String registrationNumber) implements Vehicle {

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
