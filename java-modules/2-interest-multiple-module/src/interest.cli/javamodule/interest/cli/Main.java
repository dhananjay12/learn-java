package javamodule.interest.cli;

import java.util.Scanner;
import javamodule.simple.interest.SimpleInterest;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to simple Interest Calculator");
        double pa, n, r, si;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the principle amount:");
        pa = s.nextDouble();
        System.out.println("Enter the No.of years:");
        n = s.nextDouble();
        System.out.println("Enter the Rate of  interest");
        r = s.nextDouble();

        si = new SimpleInterest().calculate(pa, n, r);
        System.out.println("Simple Interest======> " + si);

    }

}
