package mynotes.java8.lambda;

public class LambdaChild extends LambdaParent{
	
	final String var="LambdaChild";
	
	interface Family{
		void display(String member);
	}
	public void testScope(String var){
		Family aFamily=(fVar)->{
			System.out.println("Inner Local="+fVar);
			System.out.println("Outer Local="+var);
			System.out.println("This="+this.var);
			System.out.println("Super="+super.var);
		};		
		aFamily.display(var);
	}	
	public static void main(String[] args) {
		LambdaChild aLambdaChild=new LambdaChild();
		aLambdaChild.testScope("Lambda");
	}
}
