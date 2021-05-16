package mynotes.QandA;

public class Employee implements Cloneable{
	
	private int id;
	private String name;
	public Employee(){}
	public Employee(int id,String name){
		this.id=id;
		this.name=name;
	}
	@Override
	public String toString() {
		return "id=>"+this.id+"name=>"+this.name;
	}
	@Override
	protected Employee clone() {
		Employee clone = null;
		try {
			clone = (Employee) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e); // won't happen
		}
		return clone;
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
