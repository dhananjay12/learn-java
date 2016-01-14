package mynotes.concurrency.basic;

class ImplementRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Thread " + Thread.currentThread().getName()
					+ " running " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadByRunnable {
	public static void main(String[] args) {
		System.out.println("Thread = " +Thread.currentThread().getName());
		Thread t1 = new Thread(new ImplementRunnable(), "t1");
		Thread t2 = new Thread(new ImplementRunnable(), "t2");
		t1.start();
		t2.start();
		System.out.println("Thread = " +Thread.currentThread().getName());
	}
}
