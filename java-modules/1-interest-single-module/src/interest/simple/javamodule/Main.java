package simple.javamodule;

import java.util.Scanner;

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
        si = (pa * n * r) / 100;
        System.out.println("Simple Interest======> "+ si);

    }

}
