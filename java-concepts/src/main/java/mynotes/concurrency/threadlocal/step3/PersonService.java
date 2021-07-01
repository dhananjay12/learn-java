package mynotes.concurrency.threadlocal.step3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import mynotes.concurrency.threadlocal.persons.Person;
import mynotes.concurrency.threadlocal.persons.PersonStorage;

public class PersonService implements Callable<String> {
    PersonStorage storage;
    private final int id;

    public PersonService(int id, PersonStorage storage) {
        this.id = id;
        this.storage = storage;
    }

    @Override
    public String call(){
        System.out.println(Thread.currentThread().getName());
        Person person = storage.find(id);
        Calendar birthDate = person.getDob();
        SimpleDateFormat sdf = ThreadSafeDateFormatter.sdf.get();
        return sdf.format(birthDate.getTime());
    }
}

class ThreadSafeDateFormatter {
    public static ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MM-yyyy"));
}

class Main {
    static PersonStorage storage = new PersonStorage();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(threadPool.submit(new PersonService(i + 1, storage)));
        }

        Thread.sleep(5000);

        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}