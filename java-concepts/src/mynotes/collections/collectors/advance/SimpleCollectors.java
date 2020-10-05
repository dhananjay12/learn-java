package mynotes.collections.collectors.advance;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class SimpleCollectors {

    public static Collector<String, ?, List<Person>> toPersonList() {
        return collectingAndThen(
            toList(),
            list -> {
                if (list.size() % 2 != 0) {
                    throw new RuntimeException("Cannot create Persons with odd numbers of list");
                }

                final List<Person> persons = new ArrayList<>();

                for (int i = 0; i < list.size(); i += 2) {
                    final Person person = new Person(list.get(i), list.get(i + 1));
                    persons.add(person);
                }
                return persons;
            }
        );
    }

}
