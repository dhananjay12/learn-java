package mynotes.collections.basics;

public class TestToString {
	
	public int value;
	@Override
	public String toString() {
		return"This is TestToString with value "+this.value;
	}
	
	public static void main(String[] args) {
		TestToString aTestToString=new TestToString();
		aTestToString.value=1;
		System.out.println(aTestToString);
	}

}
