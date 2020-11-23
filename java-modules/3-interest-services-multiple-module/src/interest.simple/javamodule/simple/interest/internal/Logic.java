package javamodule.simple.interest.internal;

public class Logic {

    public double interest(double amount, double numOfYears, double rateOfInterest) {
        return (amount * numOfYears * rateOfInterest) / 100;
    }
}