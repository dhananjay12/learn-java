package mynotes.java8.lambda;

public class MultipleInterfaceImpl {
	
	public static void main(String[] args) {
		MultiplyInterface aMultiplyInterface=(a,b)->{
			System.out.println("a==>"+a+"  b==>"+b);
			return a*b;
			};
			 
			System.out.println(aMultiplyInterface.multiply(2, 3));
	}
	
	private static void  test1(){
		int temp=100;
		//temp=10; // local varialbe must be final or effectively final
		MultiplyInterface impl1=new MultiplyInterface() {
		@Override
		public int multiply(int a, int b) {
		 
		System.out.println("temp==>"+temp);
		return a*b;
		}
		};
		System.out.println("Without Lambda==>"+impl1.multiply(2, 3));
		 
		MultiplyInterface impl2=(a,b)->{
		System.out.println("temp==>"+temp);
		return a *b;
		 
		};
		System.out.println("With Lambda==>"+impl2.multiply(2, 3));
	}
	
	private static void  test2(){
		int temp=100;
		 
		MultiplyInterface impl1=new MultiplyInterface() {
		@Override
		public int multiply(int a, int b) {
		int temp=10;
		System.out.println("temp==>"+temp);
		return a*b;
		}
		};
		System.out.println("Without Lambda==>"+impl1.multiply(2, 3));
		 
		MultiplyInterface impl2=(a,b)->{
		// int temp=10; //temp cannot redeclare another local variable defined in an enclosing scope.
		System.out.println("temp==>"+temp);
		return a *b;
		 
		};
		System.out.println("With Lambda==>"+impl2.multiply(2, 3));
	}

}
