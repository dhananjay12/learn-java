package mynotes.concurrency.basic;

public class SynchronizedMethodExample {

	private int count = 0;
	
	public synchronized int increment(){
		return count++;
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					increment();
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					increment();
				}

			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(count);
	}
	
	public static void main(String[] args) {
		SynchronizedMethodExample example = new SynchronizedMethodExample();
		example.doWork();
	
	}

}
