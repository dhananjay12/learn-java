package mynotes.concurrency.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizationMadeSlow {

	private List<Integer> l1 = new ArrayList<Integer>();
	private List<Integer> l2 = new ArrayList<Integer>();
	private Random random = new Random();

	// Doing something - adding in l1

	public synchronized void doTask1() {

		l1.add(random.nextInt(100));
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Doing something completely independent from doTask1 -adding in l2

	public synchronized void doTask2() {

		l2.add(random.nextInt(100));
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doBothTask() {
		for (int i = 0; i < 1000; i++) {
			doTask1();
			doTask2();
		}
	}

	public void test() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				doBothTask();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				doBothTask();
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("Starting...");
		SynchronizationMadeSlow aSynchronizationMadeSlow = new SynchronizationMadeSlow();
		long start = System.currentTimeMillis();
		aSynchronizationMadeSlow.test();
		long end = System.currentTimeMillis();
		System.out.println("Total Time take==" + (end - start));
	}

}
