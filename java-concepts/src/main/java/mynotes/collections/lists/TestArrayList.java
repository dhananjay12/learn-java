package mynotes.collections.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestArrayList {
	
	public static void testBasicFunctions(List<Person> personList){
		System.out.println("List count=>"+personList.size());
		System.out.println("Get index 0=>"+personList.get(0));
		System.out.println("Replace index 2=>"+personList.set(2, new Person("Ryan", 26)));//previous object will be returned
		System.out.println("List count=>"+personList.size());
		personList.add(2, new Person("Sam", 30));//the object here will be added and other element will be shifted right
		System.out.println("List count=>"+personList.size());
		System.out.println("Get index 2=>"+personList.get(2));
		System.out.println("Get index 3=>"+personList.get(3));
		System.out.println("Removing at index 2=>"+personList.remove(2));//deletes and return the element
		System.out.println("List count=>"+personList.size());
	}
	
	public static void testIterator(List<Person> personList){
		Iterator<Person> myInterator=personList.iterator();
		while(myInterator.hasNext()){
			Person p=myInterator.next();
			System.out.println(p);
			if(p.getAge()==32){
				myInterator.remove();
			}
			if(p.getAge()==22){
				p.setAge(24);
			}
		}
		System.out.println("After removing/updating");
		myInterator=personList.iterator();
		while(myInterator.hasNext()){
			System.out.println(myInterator.next());
		}
		/*for (Person person : personList) {
			System.out.println(person);
			if(person.getAge()==27){
				personList.remove(person);
			}
			
		}*/
	}

	public static void main(String[] args) {
		List<Person> personList=new ArrayList<Person>();
		personList.add(new Person("Tom", 22));
		personList.add(new Person("Jake", 32));
		personList.add(new Person("Stan", 25));
		personList.add(new Person("John", 27));
		TestArrayList.testIterator(personList);
		
	}
	
	
}
