package mynotes.java8.lambda;

public class CapturingLambda {
	
	interface Greetings{
		String greet(String name);
	}
	
	public void testGreet(String name,String language){		
		//language=""; //This is not allowed
		Greetings greetImpl=(String s)->{
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
		CapturingLambda aCapturingLambda=new CapturingLambda();				
		aCapturingLambda.testGreet("Sam", "es");
		aCapturingLambda.testGreet("Sam", "en");	
	}

}
