package mynotes.concurrency.basic;

public class WaitNotifyExampleMain {

	public static void main(String[] args) {
		final WaitNotifyExample aWaitNotifyExample = new WaitNotifyExample();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					aWaitNotifyExample.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					aWaitNotifyExample.consumes();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

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

}
