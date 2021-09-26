package com.mynotes.examples.java17.sealedStuff.withRecords;

public class Main {

    static String check(Vehicle vehicle){
        return switch (vehicle){
            case Car c -> String.format("Its a car with %d seats and registration %s", c.numberOfSeats(), c.registrationNumber());
            //Because its a record we have `registrationNumber` and the interface method is `getRegistrationNumber`
            case Motorcycle m -> String.format("Its a motorcycle with %d seats and registration %s", m.numberOfSeats(), m.getRegistrationNumber());
            default -> throw new RuntimeException("Unknown instance of Vehicle");
        };
    }

    public static void main(String[] args) {
        System.out.println(check(new Car(4,"abcd1234")));
        System.out.println(check(new Motorcycle(2,"xyz1234")));
    }
}
