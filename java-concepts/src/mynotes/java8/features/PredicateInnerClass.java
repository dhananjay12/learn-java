package mynotes.java8.features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInnerClass {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("John", 27, 98000));
		empList.add(new Employee("Jane", 25, 80000));
		empList.add(new Employee("Max", 28, 110000));
		empList.add(new Employee("Matt", 32, 150000));

		Predicate<Employee> pred = new Predicate<Employee>() {
			@Override
			public boolean test(Employee emp) {
				return (emp.getSalary() > 100000);
			}
		};

		for (Employee employee : empList) {
			if (pred.test(employee)) {
				System.out.println(employee);
			}
		}
	}

}