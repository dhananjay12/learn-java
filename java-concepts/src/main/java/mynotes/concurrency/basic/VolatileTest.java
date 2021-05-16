package mynotes.concurrency.basic;

import java.util.Scanner;

class InfiniteLoop extends Thread {

	private volatile boolean status = true;
	@Override
	public void run() {
		while (status) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		status = false;
	}
}

public class VolatileTest {

	public static void main(String[] args) {
		InfiniteLoop t1 = new InfiniteLoop();
		t1.start();
		System.out.println("Hit return to stop....");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		t1.shutdown();

	}

}
