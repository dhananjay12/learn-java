package com.mynotes.examples.java17.sealedStuff.withRecords;

public sealed interface Vehicle permits Car, Motorcycle {

    String getRegistrationNumber();

}
