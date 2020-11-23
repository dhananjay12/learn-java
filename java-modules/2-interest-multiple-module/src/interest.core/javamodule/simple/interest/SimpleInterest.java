package javamodule.simple.interest;

import java.util.Scanner;
import javamodule.simple.interest.internal.Logic;

public class SimpleInterest {

    Logic logic = new Logic();

    public double calculate(double amount, double numOfYears, double rateOfInterest) {
        if (amount <= 0 || numOfYears <= 0 || rateOfInterest <= 0) {
            throw new java.lang.RuntimeException("Negative vales not allowed");
        }

        return logic.interest(amount, numOfYears, rateOfInterest);

    }

}
