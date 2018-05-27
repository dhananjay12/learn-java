package mynotes.java8.streams.parallel;

import java.util.Arrays;
import java.util.List;

public class FindTest {

	public static List<Person> createPeople() {
		return Arrays.asList(new Person("Sara", Gender.FEMALE, 20), new Person("Sara", Gender.FEMALE, 22),
				new Person("Bob", Gender.MALE, 20), new Person("Paula", Gender.FEMALE, 32),
				new Person("Paul", Gender.MALE, 32), new Person("Jack", Gender.MALE, 25),
				new Person("Jack", Gender.MALE, 72), new Person("Jill", Gender.FEMALE, 42)

		);
	}

	public static void main(String[] args) {

		System.out.println(createPeople().parallelStream().filter(p -> p.getAge() > 30)
				.filter(p -> p.getGender() == Gender.FEMALE).map(Person::getName).findAny().orElse("not found"));

	}
}
