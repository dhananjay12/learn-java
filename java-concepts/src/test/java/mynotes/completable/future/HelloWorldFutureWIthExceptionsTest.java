package mynotes.completable.future;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloWorldFutureWIthExceptionsTest {

    @Mock
    HelloWorldFuture mockClass = mock(HelloWorldFuture.class);

    @InjectMocks
    HelloWorldFutureWithExceptions helloWorldFutureWithExceptions;

    @Test
    void helloWorld_twoCalls_exception_handle() {
        when(mockClass.returnHello()).thenThrow(new RuntimeException("Runtime Exception"));
        when(mockClass.returnWorld()).thenCallRealMethod();

        CompletableFuture<String> completableFuture = helloWorldFutureWithExceptions.helloWorld_twoCalls_exception_handle();

        completableFuture.thenAccept(result -> {
            assertEquals("WORLD", result);
        })
                .join();
    }



    @Test
    void helloWorld_twoCalls_exception_multipleHandle() {
        when(mockClass.returnHello()).thenThrow(new RuntimeException("Runtime Exception"));
        when(mockClass.returnWorld()).thenThrow(new RuntimeException("Runtime Exception"));

        CompletableFuture<String> completableFuture = helloWorldFutureWithExceptions.helloWorld_twoCalls_exception_multipleHandle();

        completableFuture.thenAccept(result -> {
            assertEquals("", result);
        })
                .join();
    }

    @Test
    void helloWorld_twoCalls_no_exception_multipleHandle() {
        when(mockClass.returnHello()).thenCallRealMethod();
        when(mockClass.returnWorld()).thenCallRealMethod();

        CompletableFuture<String> completableFuture = helloWorldFutureWithExceptions.helloWorld_twoCalls_exception_multipleHandle();

        completableFuture.thenAccept(result -> {
            assertEquals("HELLOWORLD", result);
        })
                .join();
    }

    @Test
    void helloWorld_twoCalls_exception_exceptionally() {
        when(mockClass.returnHello()).thenThrow(new RuntimeException("Runtime Exception"));
        when(mockClass.returnWorld()).thenThrow(new RuntimeException("Runtime Exception"));

        CompletableFuture<String> completableFuture = helloWorldFutureWithExceptions.helloWorld_twoCalls_exceptionally();

        completableFuture.thenAccept(result -> {
            assertEquals("", result);
        })
                .join();
    }

    @Test
    void helloWorld_twoCalls_no_exception_exceptionally() {
        when(mockClass.returnHello()).thenCallRealMethod();
        when(mockClass.returnWorld()).thenCallRealMethod();

        CompletableFuture<String> completableFuture = helloWorldFutureWithExceptions.helloWorld_twoCalls_exceptionally();

        completableFuture.thenAccept(result -> {
            assertEquals("HELLOWORLD", result);
        })
                .join();
    }

    @Test
    void helloWorld_twoCalls_no_exception_whenComplete() {
        when(mockClass.returnHello()).thenCallRealMethod();
        when(mockClass.returnWorld()).thenCallRealMethod();

        CompletableFuture<String> completableFuture = helloWorldFutureWithExceptions.helloWorld_twoCalls_exception_whenComplete();

        completableFuture.thenAccept(result -> {
            assertEquals("HELLOWORLD", result);
        })
                .join();
    }


    @Test
    void helloWorld_twoCalls_exception_whenComplete() {
        when(mockClass.returnHello()).thenThrow(new RuntimeException("Runtime Exception"));
        when(mockClass.returnWorld()).thenThrow(new RuntimeException("Runtime Exception"));

        CompletableFuture<String> completableFuture = helloWorldFutureWithExceptions.helloWorld_twoCalls_exception_whenComplete();

        completableFuture.thenAccept(result -> {
            assertEquals("", result);
        })
                .join();
    }

}