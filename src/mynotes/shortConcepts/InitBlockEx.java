package mynotes.shortConcepts;

public class InitBlockEx {
	
	static int[] values = new int[5];
	{
		System.out.println("Running initialization block.");
		for (int i = 0; i < values.length; i++) {
			values[i] = (int) (100.0 * Math.random());
		}
	}

	void listValues() {
		for (int value : values) {
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		InitBlockEx example = new InitBlockEx();
		System.out.println("First object:");
		example.listValues();
		example = new InitBlockEx();
		System.out.println("Second object:");
		example.listValues();
	}

}
