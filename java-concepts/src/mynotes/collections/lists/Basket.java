package mynotes.collections.lists;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

interface BaseA{}
class BaseB implements BaseA{
	
	public void doSomething() {};
	
}

class BaseC  extends BaseB implements BaseA{
	
	public void doSomething1() {
		System.out.println("A");
	}
	
}

class Flower{
	String name;
	Flower(String name){
		this.name=name;
	}
}

public class Basket implements BaseA{
	
	void print(Integer i) {
		System.out.println("asd");
	}
	
	void print(String s) {
		System.out.println("qwe");
	}
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, ParseException {
		Object object =new Object();
		synchronized (Thread.currentThread()) {
			object.wait();
			object.notify();
		}
		
	}

}
