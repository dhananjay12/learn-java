package mynotes.completable.future;

import java.util.concurrent.CompletableFuture;

public class Sample4 {	

	private static int compute() {
		throw new RuntimeException("something went wrong");
		//return 2;
	}
	
	public static CompletableFuture<Integer> create() {
		return CompletableFuture.supplyAsync(() -> compute());
	}

	private static int handleException2(Throwable throwable) {
		System.out.println("ERROR: "+throwable);
		return -1;
	}
	
	private static Void handleException(Throwable throwable) {
		System.out.println("ERROR: "+throwable);
		throw new RuntimeException("its beyond all hope");
	}

	public static void main(String[] args) throws Exception {
		create()
		.thenApply(data -> data * 2)
		.exceptionally(throwable -> handleException2(throwable))
		.thenAccept(data -> System.out.println(data))
		.exceptionally(throwable -> handleException(throwable));
	}	

}
