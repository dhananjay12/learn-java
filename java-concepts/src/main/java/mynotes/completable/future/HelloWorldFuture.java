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

    public  String returnHello() {
        ThreadUtil.delay(1000);
        LoggerUtil.logWithThread("inside returnHello");
        return "hello";
    }

    public  String returnWorld() {
        ThreadUtil.delay(1000);
        LoggerUtil.logWithThread("inside returnWorld");
        return "world";
    }

    public CompletableFuture<String> helloWorld() {

        return CompletableFuture.supplyAsync(() -> returnHelloWorld())
                .thenApply(String::toUpperCase);
    }

    public CompletableFuture<String> helloWorld_twoCalls() {

        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> returnHello());
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> returnWorld());

        return helloFuture.thenCombine(worldFuture, (helloResult,worldResult) -> helloResult+worldResult)
                .thenApply(String::toUpperCase);

    }

    public CompletableFuture<String> helloWorld_threeCalls() {

        CompletableFuture<String> helloFuture1 = CompletableFuture.supplyAsync(() -> returnHello());
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> returnWorld());
        CompletableFuture<String> helloFuture2 = CompletableFuture.supplyAsync(() -> returnHello());

        return helloFuture1.thenCombine(worldFuture, (helloResult1,worldResult) -> helloResult1+worldResult)
                .thenCombine(helloFuture2,(previousResult,hello2Result)->previousResult+hello2Result)
                .thenApply(String::toUpperCase);

    }

    public CompletableFuture<String> helloWorld_threeCalls_withLogs() {

        CompletableFuture<String> helloFuture1 = CompletableFuture.supplyAsync(() -> returnHello());
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> returnWorld());
        CompletableFuture<String> helloFuture2 = CompletableFuture.supplyAsync(() -> returnHello());

        return helloFuture1.thenCombine(worldFuture, (helloResult1,worldResult) -> {
                    LoggerUtil.logWithThread("inside thenCombine1");
                    return helloResult1+worldResult;
                 })
                .thenCombine(helloFuture2,(previousResult,hello2Result)-> {
                    LoggerUtil.logWithThread("inside thenCombine2");
                    return previousResult+hello2Result;
                })
                .thenApply(response ->{
                    LoggerUtil.logWithThread("inside thenApply");
                    return response.toUpperCase();
                });

    }

    public CompletableFuture<String> helloWorld_threeCalls_withLogs_usingAsync() {

        CompletableFuture<String> helloFuture1 = CompletableFuture.supplyAsync(() -> returnHello());
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> returnWorld());
        CompletableFuture<String> helloFuture2 = CompletableFuture.supplyAsync(() -> returnHello());
     // No gurantee that the nre threads will be used, unless there is a blocking call
        return helloFuture1.thenCombineAsync(worldFuture, (helloResult1,worldResult) -> {
                    LoggerUtil.logWithThread("inside thenCombine1");
                    return helloResult1+worldResult;
                })
                .thenCombineAsync(helloFuture2,(previousResult,hello2Result)-> {
                    LoggerUtil.logWithThread("inside thenCombine2");
                    return previousResult+hello2Result;
                })
                .thenApplyAsync(response ->{
                    LoggerUtil.logWithThread("inside thenApply");
                    return response.toUpperCase();
                });

    }

    public CompletableFuture<String> worldFuture(String input) {
        return CompletableFuture.supplyAsync(()->{
            ThreadUtil.delay(1000);
            return input+" world";
        });
    }

    public CompletableFuture<String> helloWorld_thenCompose() {

        return CompletableFuture.supplyAsync(() -> returnHello())
                .thenCompose((previousResult)->worldFuture(previousResult))
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
