package mynotes.collections.collectors.simple;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CollectorsTest {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            final String input = scanner.nextLine();

            final Optional<Person> result = list().stream()
                .filter(p -> p.getFname().equalsIgnoreCase(input))
                .findFirst();

            result.ifPresentOrElse(
                person -> System.out.println(person),
                () -> System.err.printf("No person found with the name '%s'%n", input)
            );
        }

        scanner.close();

    }

    private static List<Person> list() {
        return List.of(
            new Person("John", "Doe"),
            new Person("Jane", "Doe"),
            new Person("Max", "Payne"),
            new Person("John", "Constantine"));
    }

}
