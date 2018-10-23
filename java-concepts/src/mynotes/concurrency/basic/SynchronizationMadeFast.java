package mynotes.concurrency.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizationMadeFast {

	private List<Integer> l1 = new ArrayList<Integer>();
	private List<Integer> l2 = new ArrayList<Integer>();
	private Random random = new Random();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	// Doing something - adding in l1

	public void doTask1() {
		synchronized (lock1) {
			l1.add(random.nextInt(100));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Doing something completely independent from doTask1 -adding in l2

	public void doTask2() {
		synchronized (lock2) {
			l2.add(random.nextInt(100));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		SynchronizationMadeFast aSynchronizationMadeFast = new SynchronizationMadeFast();
		long start = System.currentTimeMillis();
		aSynchronizationMadeFast.test();
		long end = System.currentTimeMillis();
		System.out.println("Total Time take==" + (end - start));
	}

}
