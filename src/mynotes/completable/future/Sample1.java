package mynotes.completable.future;

import java.util.concurrent.CompletableFuture;

public class Sample1 {

	public static CompletableFuture<Integer> create() {
		return CompletableFuture.supplyAsync(() -> 2);
	}

	public static void main(String[] args) {
		create()
		.thenApply(data -> data*10.0)
		.thenAccept( data-> System.out.println(data))
		        .thenRun(() -> System.out.println("Never Dies"))
				.thenRun(() -> System.out.println("Really, Never Dies"));
	}

}
