package mynotes.java8.lambda;

public class LambdaTest1 {

	public static void main(String[] args) {
		Runnable r= ()-> System.out.println("Hello from Lambda");
		Thread t3 =new Thread(r);
		t3.start();
	}
}
