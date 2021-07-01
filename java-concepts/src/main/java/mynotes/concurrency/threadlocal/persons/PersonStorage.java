package mynotes.concurrency.threadlocal.persons;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PersonStorage {

    private final Map<Integer, Person> storage = new ConcurrentHashMap<>();

    {
        save(new Person(1, "Carena", new GregorianCalendar(1994, Calendar.JANUARY,1)));
        save(new Person(2, "Lanie", new GregorianCalendar(1987, Calendar.FEBRUARY,2)));
        save(new Person(3, "Sela", new GregorianCalendar(1981, Calendar.MAY,3)));
        save(new Person(4, "Farrah", new GregorianCalendar(1990, Calendar.MARCH,4)));
        save(new Person(5, "Sandie", new GregorianCalendar(1994, Calendar.JUNE,5)));
        save(new Person(6, "Bunnie", new GregorianCalendar(1991, Calendar.APRIL,6)));
        save(new Person(7, "Tamma", new GregorianCalendar(1999, Calendar.AUGUST,7)));
        save(new Person(8, "Karrah", new GregorianCalendar(1990, Calendar.JULY,8)));
        save(new Person(9, "Zabrina", new GregorianCalendar(1985, Calendar.OCTOBER,9)));
        save(new Person(10, "Shayne", new GregorianCalendar(1984, Calendar.SEPTEMBER,10)));
    }

    public void save(Person person) {
        storage.put(person.getId(), person);
    }

    public Person find(int id) {
        Person person = storage.get(id);
        if (person == null) {
            throw new RuntimeException("Person not found with id=" + id);
        }

        return person;
    }
}
