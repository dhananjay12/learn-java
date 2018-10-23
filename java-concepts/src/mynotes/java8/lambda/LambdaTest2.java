package mynotes.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest2 {
	
	private static void test1(){
		List<String> stringList=Arrays.asList("AA","aa","BB","BC","cc");
		System.out.println("Old way=>");
		for (String string : stringList) {
		System.out.println(string);
		}
		 
		System.out.println("New way=>");
		stringList.forEach(string -> System.out.println(string));
	}
	
	private static void test2(){
		List<String> stringList=Arrays.asList("AA","aa","BB","BC","cc");
		Collections.sort(stringList);
		System.out.println("Collections.sort default case sensitive=>");
		stringList.forEach(string -> System.out.println(string));
		//Implementing comparator using anonmymous class
		Collections.sort(stringList,new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
		return o1.compareToIgnoreCase(o2);
		}
		});
		System.out.println("Collections.sort comparator case insensitive=>");
		stringList.forEach(string -> System.out.println(string));
		}
	
	private static void test3(){
		List<String> stringList=Arrays.asList("AA","aa","BB","BC","cc");
		Comparator<String> comp= (o1,o2)-> o1.compareToIgnoreCase(o2);
		Collections.sort(stringList,comp);
		System.out.println("Collections.sort comparator using Lambda case insensitive=>");
		stringList.forEach(string -> System.out.println(string));
	}
	
	public static void main(String[] args) {
		test3();
	}

}
