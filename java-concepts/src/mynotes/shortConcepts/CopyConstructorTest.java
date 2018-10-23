package mynotes.shortConcepts;

class Employee{
	private int id;
	private String name;
	//Parameterized constructor
	public Employee(int id,String name) {
		this.id=id;
		this.name=name;
	}
	//copy constructor
	public Employee(Employee original){
		this.id=original.id;
		this.name=original.name;
	}
	@Override
	public String toString() {
		return "id=>"+this.id+"  name=>"+this.name;
	}	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

public class CopyConstructorTest {
	public static void main(String[] args) {
		Employee emp1=new Employee(1,"abcd");
		Employee emp2=new Employee(emp1);
		System.out.println("emp1=>"+emp1);
		emp1.setName("qwerty");
		System.out.println("emp1=>"+emp1);
		System.out.println("emp2=>"+emp2);
	}
	
	
}
