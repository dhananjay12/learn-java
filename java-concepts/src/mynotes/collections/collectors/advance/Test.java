package mynotes.collections.collectors.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            final String input = scanner.nextLine();

            try {
                final List<String> allStrings = Arrays.stream(input.split("\\s"))
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

                if (allStrings.size() % 2 != 0) {
                    throw new RuntimeException("Cannot create Persons with odd numbers of list");
                }

                final List<Person> persons = new ArrayList<>();
                for (int i = 0; i < allStrings.size(); i += 2) {
                    final Person person = new Person(allStrings.get(i),allStrings.get(i + 1) );
                    persons.add(person);
                }

                System.out.println("----List----");
                persons.forEach(
                    person -> System.out.println(person)
                );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        scanner.close();

    }

}
