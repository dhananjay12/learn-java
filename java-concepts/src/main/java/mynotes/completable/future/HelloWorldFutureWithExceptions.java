package mynotes.completable.future;

import mynotes.utils.LoggerUtil;
import mynotes.utils.ThreadUtil;

import java.util.concurrent.CompletableFuture;

public class HelloWorldFutureWithExceptions {

    HelloWorldFuture helloWorldFuture = new HelloWorldFuture();

    public CompletableFuture<String> helloWorld_twoCalls_exception_handle() {

        CompletableFuture<String> helloFuture1 = CompletableFuture.supplyAsync(() -> helloWorldFuture.returnHello());
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> helloWorldFuture.returnWorld());

        return helloFuture1
                .handle((response, exception) -> {
                    LoggerUtil.logWithThread("Exception :" + exception.getMessage());
                    return "";
                })
                .thenCombine(worldFuture, (helloResult1, worldResult) -> helloResult1 + worldResult)
                .thenApply(String::toUpperCase);

    }

    public CompletableFuture<String> helloWorld_twoCalls_exception_multipleHandle() {

        CompletableFuture<String> helloFuture1 = CompletableFuture.supplyAsync(() -> helloWorldFuture.returnHello());
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> helloWorldFuture.returnWorld());

        return helloFuture1
                .handle((response, exception) -> {
                    if(exception!=null) {
                        LoggerUtil.logWithThread("Exception in hello:" + exception.getMessage());
                        return "";
                    }else{
                        return response;
                    }
                })
                .thenCombine(worldFuture, (helloResult1, worldResult) -> helloResult1 + worldResult)
                .handle((response, exception) -> {
                    if(exception!=null) {
                        LoggerUtil.logWithThread("Exception in world:" + exception.getMessage());
                        return "";
                    }else{
                        return response;
                    }

                })
                .thenApply(String::toUpperCase);

    }

    public CompletableFuture<String> helloWorld_twoCalls_exceptionally() {

        CompletableFuture<String> helloFuture1 = CompletableFuture.supplyAsync(() -> helloWorldFuture.returnHello());
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> helloWorldFuture.returnWorld());

        return helloFuture1
                .exceptionally((exception) -> {
                        LoggerUtil.logWithThread("Exception in hello:" + exception.getMessage());
                        return "";
                })
                .thenCombine(worldFuture, (helloResult1, worldResult) -> helloResult1 + worldResult)
                .exceptionally((exception) -> {
                    LoggerUtil.logWithThread("Exception in world:" + exception.getMessage());
                    return "";
                })
                .thenApply(String::toUpperCase);

    }

    public CompletableFuture<String> helloWorld_twoCalls_exception_whenComplete() {

        CompletableFuture<String> helloFuture1 = CompletableFuture.supplyAsync(() -> helloWorldFuture.returnHello());
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> helloWorldFuture.returnWorld());

        return helloFuture1
                .whenComplete((response, exception) -> {
                    LoggerUtil.logWithThread("In WenComplete of hello");
                    if(exception!=null) {
                        LoggerUtil.logWithThread("Exception in hello:" + exception.getMessage());
                    }
                })
                .thenCombine(worldFuture, (helloResult1, worldResult) -> helloResult1 + worldResult)
                .whenComplete((response, exception) -> {
                    LoggerUtil.logWithThread("In WenComplete of world");
                    if(exception!=null) {
                        LoggerUtil.logWithThread("Exception in world:" + exception.getMessage());
                    }
                })
                .exceptionally((exception)->{
                    LoggerUtil.logWithThread("Exception at the end:" + exception.getMessage());
                    return "";
                })
                .thenApply(String::toUpperCase);
    }

}
