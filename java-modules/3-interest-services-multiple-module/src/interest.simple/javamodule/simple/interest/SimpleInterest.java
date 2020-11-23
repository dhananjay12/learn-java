package javamodule.simple.interest;

import java.util.Scanner;
import javamodule.simple.interest.internal.Logic;
import javamodule.interest.api.Interest;

public class SimpleInterest implements Interest {

    Logic logic = new Logic();

    public String getName(){
        return "Simple Interest";
    }

    public double calculate(double amount, double numOfYears, double rateOfInterest) {
        if (amount <= 0 || numOfYears <= 0 || rateOfInterest <= 0) {
            throw new java.lang.RuntimeException("Negative vales not allowed");
        }

        return logic.interest(amount, numOfYears, rateOfInterest);

    }

}
