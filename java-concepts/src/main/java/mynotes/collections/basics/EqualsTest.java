package mynotes.collections.basics;

public class EqualsTest {
	public static void main(String[] args) {
		Employee aEmployee=new Employee();
		aEmployee.setId(123);
		Employee bEmployee=new Employee();
		bEmployee.setId(123);
		System.out.println(aEmployee.equals(bEmployee));
	}

}
