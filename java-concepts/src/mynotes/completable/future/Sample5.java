package mynotes.completable.future;

import java.util.concurrent.CompletableFuture;

public class Sample5 {
	
	private static int handleException(Throwable throwable) {
		System.out.println("ERROR: "+throwable);
		return -1;
		
	}

	public static void main(String[] args) throws Exception {

		CompletableFuture<Integer> future = 
				new CompletableFuture<Integer>();
		future
				.thenApply(data -> data * 2)
				.exceptionally(throwable->handleException(throwable))
				.thenApply(data -> data + 1)
				.thenAccept(data -> System.out.println(data));
		
		System.out.println("built the pipeline");		
				
		sleep(1000);
		
		if(Math.random()>0.5) {
			future.completeExceptionally( new RuntimeException("something went wrong"));
		}else {
			future.complete(2);
		}		
		
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
