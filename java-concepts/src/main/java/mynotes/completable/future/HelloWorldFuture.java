package mynotes.completable.future;

import mynotes.utils.LoggerUtil;
import mynotes.utils.ThreadUtil;

import java.util.concurrent.CompletableFuture;

public class HelloWorldFuture {

    public  String returnHelloWorld() {
        ThreadUtil.delay(1000);
        LoggerUtil.logWithThread("inside returnHelloWorld");
        return "hello world";
    }

    public CompletableFuture<String> helloWorld() {

        return CompletableFuture.supplyAsync(() -> returnHelloWorld())
                .thenApply(String::toUpperCase);
    }

    public static void main(String[] args) {
        HelloWorldFuture helloWorldFuture = new HelloWorldFuture();
        helloWorldFuture.helloWorld()
                .thenAccept(result -> {
                    LoggerUtil.logWithThread("Result : "+ result);
                })
                .join();
        LoggerUtil.log("END");
    }
}
