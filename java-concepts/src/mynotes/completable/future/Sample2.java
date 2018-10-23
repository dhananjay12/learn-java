package mynotes.completable.future;

import java.util.concurrent.CompletableFuture;

public class Sample2 {

	public static CompletableFuture<Integer> create() {
		return CompletableFuture.supplyAsync(() -> compute());
	}

	private static int compute() {
		System.out.println("compute: " + Thread.currentThread());
		sleep(1000);
		return 2;
	}

	private static void printIt(int data) {
		System.out.println(data + "--" + Thread.currentThread());
	}

	public static void main(String[] args) throws Exception {
		System.out.println("In main " + Thread.currentThread());
		CompletableFuture<Integer> future = create();	
		sleep(100);
		future.thenAccept(data -> printIt(data));
		
		System.out.println("here");
		sleep(1000);
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
