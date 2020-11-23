package javamodule.interest.cli;

import java.util.Scanner;
import java.util.ServiceLoader;

import javamodule.interest.api.Interest;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to simple Interest Calculator");
        double amount, numOfYears, rateOfInterest;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the principle amount:");
        amount = s.nextDouble();
        System.out.println("Enter the No.of years:");
        numOfYears = s.nextDouble();
        System.out.println("Enter the Rate of  interest");
        rateOfInterest = s.nextDouble();

        Iterable<Interest> listOfCalculators = ServiceLoader.load(Interest.class);
        for (Interest calulator : listOfCalculators) {
            System.out.println(calulator.getName() + " ===> " + calulator.calculate(amount, numOfYears, rateOfInterest));
        }
    }

}
