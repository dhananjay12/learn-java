package mynotes.concurrency.basic;

class ExtendThread extends Thread {

	public ExtendThread(String name) {
		super(name);
	}

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

public class ThreadByExtending {

	public static void main(String[] args) {

		System.out.println("Thread = " + Thread.currentThread().getName());
		ExtendThread t1 = new ExtendThread("t1");
		ExtendThread t2 = new ExtendThread("t2");
		t1.start();
		t2.start();
		System.out.println("Thread = " + Thread.currentThread().getName());

	}

}
