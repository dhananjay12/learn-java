package mynotes.shortConcepts;

import java.io.FileNotFoundException;
import java.sql.SQLException;

class Parent1{
	public int a = 10;
	
	public void test() {
		System.out.println("test");
	}
	
	public static  void test1() {
		System.out.println("test1");
	}
}

class Child1 extends Parent1{
	public int a = 20;
	
	public void test() {
		System.out.println("test");
	}
	
	public static  void test1() {
		System.out.println("test1");
	}
}

abstract class MyClass1{
	public abstract void test() throws SQLException;
}
interface MyClass2{
	public abstract void test() throws FileNotFoundException,ArrayIndexOutOfBoundsException;
	
	
}

class MyClass3 extends MyClass1 implements MyClass2{

	@Override
	public void test() throws  ArrayIndexOutOfBoundsException{
		// TODO Auto-generated method stub
		
	}
	
}

public class OverridingTest {
	public static void main(String[] args) {
		Parent1 p=new Child1();
		p.test();
		p.test1();
		System.out.println(p.a);
	}
}
