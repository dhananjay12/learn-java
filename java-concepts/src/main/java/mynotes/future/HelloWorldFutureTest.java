package mynotes.future;

import mynotes.completable.future.HelloWorldFuture;
import mynotes.utils.ThreadUtil;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldFutureTest {

    HelloWorldFuture helloWorldFuture = new HelloWorldFuture();

    @Test
    void helloWorld() {
        CompletableFuture<String> completableFuture = helloWorldFuture.helloWorld();

        completableFuture.thenAccept(result -> {
            assertEquals("HELLO WORLD", result);
        })
                .join();
    }

    @Test
    void helloWorld_twoCalls() {
        ThreadUtil.startTimer();
        CompletableFuture<String> completableFuture = helloWorldFuture.helloWorld_twoCalls();

        completableFuture.thenAccept(result -> {
            assertEquals("HELLOWORLD", result);
        })
                .join();
        ThreadUtil.stopTimer();
    }

    @Test
    void helloWorld_threeCalls() {
        ThreadUtil.startTimer();
        CompletableFuture<String> completableFuture = helloWorldFuture.helloWorld_threeCalls();

        completableFuture.thenAccept(result -> {
            assertEquals("HELLOWORLDHELLO", result);
        })
                .join();
        ThreadUtil.stopTimer();
    }

    @Test
    void helloWorld_threeCalls_withLogs() {
        ThreadUtil.startTimer();
        CompletableFuture<String> completableFuture = helloWorldFuture.helloWorld_threeCalls_withLogs();

        completableFuture.thenAccept(result -> {
            assertEquals("HELLOWORLDHELLO", result);
        })
                .join();
        ThreadUtil.stopTimer();
    }

    @Test
    void helloWorld_threeCalls_withLogsAync() {
        ThreadUtil.startTimer();
        CompletableFuture<String> completableFuture = helloWorldFuture.helloWorld_threeCalls_withLogs_usingAsync();

        completableFuture.thenAccept(result -> {
            assertEquals("HELLOWORLDHELLO", result);
        })
                .join();
        ThreadUtil.stopTimer();
    }

    @Test
    void helloWorld_thenCompose() {
        ThreadUtil.startTimer();
        CompletableFuture<String> completableFuture = helloWorldFuture.helloWorld_thenCompose();

        completableFuture.thenAccept(result -> {
            assertEquals("HELLO WORLD", result);
        })
                .join();
        ThreadUtil.stopTimer();
    }
}