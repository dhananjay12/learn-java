package mynotes.concurrency.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        Runnable worker1 = () -> {
            while (true) {
                System.out.println("W1: " + Thread.currentThread().getId() + " " + System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable worker2 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("W2: " + Thread.currentThread().getId() + " " + System.currentTimeMillis());
        };

        Runnable worker3 = () ->
            System.out.println("W2: " + Thread.currentThread().getId() + " " + System.currentTimeMillis());

        scheduledExecutorService.execute(worker1);
        scheduledExecutorService.execute(worker2);
        scheduledExecutorService.scheduleAtFixedRate(worker3, 3, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(worker3, 10, TimeUnit.SECONDS);

    }

}