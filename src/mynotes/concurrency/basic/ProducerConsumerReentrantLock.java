package mynotes.concurrency.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExampleReentrantLock {
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	//private List<Integer> list = new ArrayList<>();
	
	public void producer() throws InterruptedException {
		lock.lock();
		System.out.println("Producer method...");
		condition.await();
		System.out.println("Producer method again...");
	}
	
	public void consumer() throws InterruptedException {
		lock.lock();
		Thread.sleep(2000);
		System.out.println("Consumer method...");
		Thread.sleep(3000);
		condition.signal();
		lock.unlock();
	}
}

public class ProducerConsumerReentrantLock {

	static ExampleReentrantLock aExample = new ExampleReentrantLock();

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					aExample.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					aExample.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}
}

