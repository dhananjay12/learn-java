package mynotes.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorBasicExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 5; i++) {
			executorService.execute(new Worker1());
		}
	}

}

class Worker1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}