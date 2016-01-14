package mynotes.collections.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person>, Comparator<Person> {

	private String name;
	private int age;

	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	/*
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Person o) {
		return (this.name).compareTo(o.name);
	}

	/*
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Person o1, Person o2) {
		return o1.age - o2.age;
	}

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("jake", 20));
		list.add(new Person("sam", 30));
		list.add(new Person("dave", 26));
		list.add(new Person("roger", 28));

		Collections.sort(list);// Sorts the array list

		for (Person a : list)
			// printing the sorted list of names
			System.out.print(a.getName() + "  : " + a.getAge() + ", ");

		// Sorts the array list using comparator
		Collections.sort(list, new Person());
		System.out.println(" ");
		for (Person a : list)
			// printing the sorted list of ages
			System.out.print(a.getName() + "  : " + a.getAge() + ", ");
	}

}
