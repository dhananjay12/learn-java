package com.mynotes.samples.benchmarking;

public class MicroBenchMark {

    public static void main(String[] args) throws InterruptedException {
        CheckPrimeService checkPrimeService = new CheckPrimeService();

        //warm up period
		for (int i = 1; i < 10000; i++){
		    checkPrimeService.isPrime_inefficient(i);
        }

		Thread.sleep(2000);
        System.out.println("warmup finished");

		long start = System.currentTimeMillis();

		for (int i = 1; i < 50000; i++){
		    checkPrimeService.isPrime_inefficient(i);
        }
		long end = System.currentTimeMillis();
		System.out.println("Time taken ::" + (end - start) + " ms");


		//warm up period
		for (int i = 1; i < 10000; i++){
		    checkPrimeService.isPrime_efficient(i);
        }

		Thread.sleep(2000);
        System.out.println("warmup finished");

		start = System.currentTimeMillis();

		for (int i = 1; i < 50000; i++){
		    checkPrimeService.isPrime_efficient(i);
        }
		end = System.currentTimeMillis();
		System.out.println("Time taken ::" + (end - start) + " ms");


    }
}
