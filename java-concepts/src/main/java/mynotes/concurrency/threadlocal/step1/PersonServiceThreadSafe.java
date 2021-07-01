package mynotes.concurrency.threadlocal.step1;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import mynotes.concurrency.threadlocal.persons.Person;
import mynotes.concurrency.threadlocal.persons.PersonStorage;

public class PersonServiceThreadSafe implements Callable<String> {
    PersonStorage storage;
    DateTimeFormatter df; //Thread safe
    private int id;

    public PersonServiceThreadSafe(int id, PersonStorage storage, DateTimeFormatter df) {
        this.id = id;
        this.storage = storage;
        this.df = df;

    }

    @Override
    public String call() throws Exception {
        Person person = storage.find(id);
        Calendar birthDate = person.getDob();
        return df.format(LocalDate.ofInstant(birthDate.toInstant(), ZoneId.systemDefault()));
    }
}

class RunMain {
    static PersonStorage storage = new PersonStorage();
    static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(threadPool.submit(new PersonServiceThreadSafe(i+1, storage,df)));
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