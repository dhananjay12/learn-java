	package mynotes.shortConcepts;
	
	public class StaticBlocksEx {
	
		static int[] values = new int[5];
		static {
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
			StaticBlocksEx example = new StaticBlocksEx();
			System.out.println("First object:");
			example.listValues();
			example = new StaticBlocksEx();
			System.out.println("Second object:");
			example.listValues();
		}
	
	}
