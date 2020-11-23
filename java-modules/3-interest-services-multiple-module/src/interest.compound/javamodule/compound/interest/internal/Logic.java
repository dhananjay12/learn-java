package javamodule.compound.interest.internal;

public class Logic {

    public double interest(double amount, double numOfYears, double rateOfInterest) {
        return amount * Math.pow(1.0 + rateOfInterest / 100.0, numOfYears) - amount;
    }
}