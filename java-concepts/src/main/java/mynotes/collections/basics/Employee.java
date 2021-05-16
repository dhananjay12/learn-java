package mynotes.collections.basics;

public class Employee {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Employee) && (((Employee) obj).getId() == this.id)) {
			return true;
		} else {
			return false;
		}

	}

}
