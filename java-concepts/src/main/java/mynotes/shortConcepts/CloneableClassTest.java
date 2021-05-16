package mynotes.shortConcepts;

class CloneableClass implements Cloneable {

	private int x;

	public CloneableClass(int x) {
		this.x = x;
	}

	public int getX() {

		return this.x;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public CloneableClass testClone() {
		try {
			return (CloneableClass) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setX(int x) {
		this.x = x;
	}

}

public class CloneableClassTest {

	public static void main(String[] args) {

		CloneableClass obj1 = new CloneableClass(100);
		CloneableClass obj2 = (CloneableClass) obj1.clone();
		CloneableClass obj3 = obj1.testClone();
		System.out.println("obj1="+obj1.getX());
		obj1.setX(0);
		System.out.println("obj1="+obj1.getX());
		System.out.println("obj2="+obj2.getX());
		System.out.println("obj3="+obj3.getX());
	}

}