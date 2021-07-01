package mynotes.concurrency.threadlocal.persons;

import java.time.LocalDate;
import java.util.Calendar;

public class Person {

    private final int id;
    private final String name;
    private final Calendar dob; //Only for example, use LocalDate instead

    public Person(int id, String name, Calendar dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (!name.equals(person.name)) return false;
        return dob.equals(person.dob);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + dob.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Calendar getDob() {
        return dob;
    }
}
