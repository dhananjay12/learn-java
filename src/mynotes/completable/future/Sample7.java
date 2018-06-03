package mynotes.completable.future;

import java.util.concurrent.CompletableFuture;

public class Sample7 {

	public static CompletableFuture<Integer> create(int number) {
		return CompletableFuture.supplyAsync(() -> number);
	}

	public static CompletableFuture<Integer> transform(int number) {
		return CompletableFuture.supplyAsync(() -> number + 2);
	}

	public static void main(String[] args) throws Exception {
		create(2)
		.thenCompose(data -> transform(data))
		.thenAccept(result->System.out.println(result));
	}

}
