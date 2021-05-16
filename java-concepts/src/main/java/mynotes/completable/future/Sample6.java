package mynotes.completable.future;

import java.util.concurrent.CompletableFuture;

public class Sample6 {

	public static CompletableFuture<Integer> create(int number) {
		return CompletableFuture.supplyAsync(() -> number);
	}

	public static void main(String[] args) throws Exception {
		create(2).thenCombine(create(3), (r1, r2) -> r1 + r2)
		.thenAccept(data-> System.out.println(data));
	}

}
