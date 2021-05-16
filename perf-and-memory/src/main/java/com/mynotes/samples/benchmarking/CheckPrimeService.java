package com.mynotes.samples.benchmarking;

public class CheckPrimeService {

    public boolean isPrime_inefficient(Integer num) {
        for (Integer i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime_efficient(int num) {
        if (num > 2 && num % 2 == 0) {
            return false;
        }
        int top = (int) Math.sqrt(num) + 1;
        for (int i = 2; i < top; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
