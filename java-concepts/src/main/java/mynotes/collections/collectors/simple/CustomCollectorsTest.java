package mynotes.collections.collectors.simple;

import static mynotes.collections.collectors.simple.CustomCollectors.findOne;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CustomCollectorsTest {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            final String input = scanner.nextLine();
            try {
                final Optional<Person> result = list().stream()
                    .filter(p -> p.getFname().equalsIgnoreCase(input))
                    .collect(findOne()); // Can have input args

                result.ifPresentOrElse(
                    person -> System.out.println(person),
                    () -> System.err.printf("No person found with the name '%s'%n", input)
                );
            } catch (Exception e) {
                System.err.println("Exception::"+e.getMessage());
            }
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
