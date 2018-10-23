package mynotes.java8.streams.parallel;

import java.util.stream.IntStream;

public class CoputingIntesiveCode {
	
	static int MAX=1500;
	
	public static double compute(double number) {
		double result =0;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				result= result+Math.sqrt(i*j);
			}
		}
		return result;
	}
	
	public static void doWork() {
		double result = IntStream.range(0, MAX).parallel().mapToDouble(CoputingIntesiveCode::compute).sum();
		System.out.println(result);
	}
	
	public static void main(String[] args) {	
		
		Timeit.code(() -> doWork());		
		
	}
	

}
