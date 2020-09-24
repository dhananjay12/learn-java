package mynotes.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFixedPool {

    public static void main(String[] args) {
        ExecutorService fixedPool= Executors.newFixedThreadPool(2);

        Worker1 worker1= new Worker1();

        Runnable worker2 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("W2: " + Thread.currentThread().getId() + " " + System.currentTimeMillis());
        };

        fixedPool.execute(worker1);
        fixedPool.execute(worker2);
        fixedPool.execute(worker2);
        fixedPool.execute(worker2);
        fixedPool.execute(worker2);

    }

}

class Worker1 implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("W1: " + Thread.currentThread().getId() + " " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}