package mynotes.completable.future;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldFutureTest {

    HelloWorldFuture helloWorldFuture = new HelloWorldFuture();

    @Test
    void helloWorld() {
        CompletableFuture<String> completableFuture = helloWorldFuture.helloWorld();

        completableFuture.thenAccept(result ->{
            assertEquals("HELLO WORLD", result);
        })
        .join();
    }
}