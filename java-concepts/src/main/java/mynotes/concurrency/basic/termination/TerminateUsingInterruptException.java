package mynotes.concurrency.basic.termination;

public class TerminateUsingInterruptException {

    public static void main(String [] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();
        thread.interrupt(); // Because thread.sleep forces to catch exception. Had it not been there, it main thread would finish but the thread would continue to work
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            //do things
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Existing blocking thread");
            }
        }
    }
}
