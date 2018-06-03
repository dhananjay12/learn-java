package mynotes.completable.future;

import java.util.concurrent.CompletableFuture;

public class Sample3 {

	public static void main(String[] args) throws Exception {

		CompletableFuture<Integer> future = 
				new CompletableFuture<Integer>();
		future
				.thenApply(data -> data * 2)
				.thenApply(data -> data + 1)
				.thenAccept(data -> System.out.println(data));
		
		System.out.println("built the pipeline");		
				
		sleep(1000);
		
		future.complete(2);
		
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
