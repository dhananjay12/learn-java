package mynotes.java8.lambda;

public class CapturingLambda2 {
	
	interface Greetings{
		String greet(String name);
	}
	
	String instanceVariable ="default";
	
	public void testGreet(String name,String language){		
		
		//language=""; //This is not allowed
		Greetings greetImpl=(String s)->{
			instanceVariable="";//Reassign of instance variables are allowed
			if(language.equalsIgnoreCase("es")){
				
				return "Hola, "+s;
			}else{
				return "Hello, "+s;
			}
		};				
		String result =greetImpl.greet(name);
		System.out.println(result);		
	}
	
	public static void main(String[] args) {
		CapturingLambda2 aCapturingLambda=new CapturingLambda2();				
		aCapturingLambda.testGreet("Sam", "es");
		aCapturingLambda.testGreet("Sam", "en");	
	}

}
