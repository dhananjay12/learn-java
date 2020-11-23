package javamodule.interest.api;

public interface Interest {

    String getName();

    double calculate(double amount, double numOfYears, double rateOfInterest);
}