package com.mynotes.examples.java17.sealedStuff.withClasses;

import java.lang.constant.ClassDesc;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class Main {

    static String check(Vehicle vehicle){
        return switch (vehicle){
            case Car c -> String.format("Its a car with %d seats", c.getNumberOfSeats());
            case Motorcycle m -> String.format("Its a motorcycle with %d seats", m.getNumberOfSeats());
            default -> throw new RuntimeException("Unknown instance of Vehicle");
        };
    }

    public static void main(String[] args) {
        Car car = new Car(4,"abcd1234");
        System.out.println(check(car));
        Motorcycle motorcycle = new Motorcycle(2,"xyz1234");
        System.out.println(check(motorcycle));

        System.out.println("Is Car sealed => " +car.getClass().isSealed());
        System.out.println("Is Car supper class sealed => " +car.getClass().getSuperclass().isSealed());

        System.out.println("All permitted subclass of "+ car.getClass().getSuperclass().getCanonicalName() +":");
        Arrays.stream(car.getClass().getSuperclass().getPermittedSubclasses()).forEach(aClass -> {
            System.out.println(aClass.getName());
        });


    }
}
