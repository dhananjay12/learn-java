package mynotes.java8.streams.parallel;

import java.util.Arrays;
import java.util.List;

public class Try {

	

	private static void printIt(int number) {
		System.out.println("p: " + number + "--" + Thread.currentThread());
	}

	private static int add(int a, int b) {
		int result = a + b;
		System.out.println("a = " + a + " b= " + b + " r = " + result + "--" + Thread.currentThread());
		return result;
	}
	
	private static int transform(int number) {
		System.out.println("t: " + number + "--" + Thread.currentThread());
		sleep(1000);
		return number * 1;
	}

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		
		numbers.parallelStream().map(e -> transform(e)).forEach(e->{});
		
	}

	private static void sleep(long millisecond) {
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
