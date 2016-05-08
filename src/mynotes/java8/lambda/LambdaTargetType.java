package mynotes.java8.lambda;

public class LambdaTargetType {
	
	interface Greetings{
		String greet(String name);
	}
	
	public void testGreet(String name, Greetings greetImpl){
		
		String result =greetImpl.greet(name);
		System.out.println(result);
		
	}
	
	public static void main(String[] args) {
		LambdaTargetType aLambdaTargetType=new LambdaTargetType();		
		Greetings greetImpl1=(String s)->"Hello, "+s;
		Greetings greetImpl2=(String s)->"Hi, "+s;
		aLambdaTargetType.testGreet("Sam", greetImpl1);
		aLambdaTargetType.testGreet("Sam", greetImpl2);
		aLambdaTargetType.testGreet("Sam", (String s)->"Greetings!! , "+s);
	}

}
