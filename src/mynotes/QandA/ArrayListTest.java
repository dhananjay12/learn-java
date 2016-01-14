package mynotes.QandA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTest {

	public static <E> List<E> withoutDuplicates(List<E> original) {
		return new ArrayList<E>(new LinkedHashSet<E>(original));
	}

	public static void withoutDuplicatesTest() {
		List<String> list1 = Arrays.asList("test1", "test2", "test1", "test3",
				"test2", "test4");
		System.out.println(list1);
		System.out.println(withoutDuplicates(list1));
	}

	public static void retainAllTest() {
		List<String> list1 = new ArrayList<String>(Arrays.asList("test1",
				"test2", "test3"));
		List<String> list2 = new ArrayList<String>(Arrays.asList("test1",
				"test2", "test4", "test5"));
		List<String> list3 = new ArrayList<String>(Arrays.asList("test1",
				"test2", "test4", "test6"));
		System.out.println("list2 before retaing=>" + list2);
		list2.retainAll(list3);
		System.out.println("list2 after retaing elements of list3=>" + list2);
		list1.retainAll(list2);
		System.out.println("list1 after retaing elements of list2=>" + list1);
	}

	public static void reverseOrderTest() {
		List unsortedList = Arrays.asList("abc", "bcd", "ade", "cde");
		System.out.println("Arraylist before: " + unsortedList);
		Collections.sort(unsortedList, Collections.reverseOrder());
		System.out.println("Arraylist in descending order: " + unsortedList);

	}

	public static void caseInsensitiveTest() {
		List<String> unsortedList = Arrays.asList("abc", "bcd", "ABC", "BCD");
		System.out.println("ArrayList before case insensitive sort: "
				+ unsortedList);
		Collections.sort(unsortedList, String.CASE_INSENSITIVE_ORDER);
		System.out.println("ArrayList after case insensitive sort: "
				+ unsortedList);
	}

	public static void testExtendsBound(List<? extends SoftwareDeveloper> slist) {}

	public static void testSuperBound(List<? super SoftwareDeveloper> slist) {}

	public static void testUnBound(List<?> slist) {}

	public static void boundedAndUnboundedTest() {
		List<SoftwareDeveloper> slist = new ArrayList<SoftwareDeveloper>();
		List<JavaDeveloper> jlist = new ArrayList<JavaDeveloper>();
		List<Employee> elist = new ArrayList<Employee>();

		testExtendsBound(slist);// OK
		testExtendsBound(jlist);// OK
		//testExtendsBound(elist);// Compile Error As only 'subclass' can be passed with extends

		testSuperBound(slist);// OK
		//testSuperBound(jlist);// Compile Error As only 'superclass' can be passed with extends
		testSuperBound(elist);// OK

		List<Object> anyList = new ArrayList<Object>();

		testUnBound(slist);// OK
		testUnBound(jlist);// OK
		testUnBound(elist);// OK
		testUnBound(anyList);// OK

	}

	public static void unmodifiableListTest() {
		List<String> list1 = new ArrayList<String>(Arrays.asList("test1", "test2", "test3"));
		System.out.println("list1 ORIGINAL=>"+list1);
          
		List<String> list2 = Collections.unmodifiableList(list1);//list2 got new cloned object 
		System.out.println("list2=>"+list2);       
		
		list1.add("test4"); //we can still modify list1
		System.out.println("list1 AFTER=>"+list1); 	
        
		list2.add("test4"); //ADD/remove/set etc NOT ALLOWED will throw runtime UnsupportedOperationException

	}
	
	public static void synchronizingArrayListTest() {
		List<String> syncList1 = Collections.synchronizedList(new ArrayList<String>());
		syncList1.add("one");
		syncList1.add("two");
		syncList1.add("three");

		// when iterating over a synchronized list, we need to synchronize access to the synchronized list
		synchronized (syncList1) {
			Iterator<String> failFastIterator = syncList1.iterator();
			while (failFastIterator.hasNext()) {
				System.out.println("item1: " + failFastIterator.next());
				failFastIterator.remove();
			}
		}
		System.out.println("syncList1: " + syncList1);
		
		CopyOnWriteArrayList<String> syncList2 = new CopyOnWriteArrayList<String>();
		syncList2.add("one");
		syncList2.add("two");
		syncList2.add("three");

	    //Synchronized block is not required in this method
	    Iterator<String> failSafeIterator  = syncList2.iterator(); 
	    while (failSafeIterator.hasNext()){
	    	System.out.println("item2: " + failSafeIterator.next());
	    	//failSafeIterator.remove();// Not supported by CopyOnWriteArrayList runtime error
	    }
	    System.out.println("syncList2: " + syncList2);

	}
	
	public static void cloningArrayListUsingCopyConstructor() {
		List<Employee> emp1=new ArrayList<Employee>();
		emp1.add(new Employee(1,"asdfg"));
		emp1.add(new Employee(2,"qwerty"));
		System.out.println("emp1 list->"+emp1);		
		List<Employee> emp2=new ArrayList<Employee>(emp1);
		emp2.get(0).setName("zxcv");		
		System.out.println("emp1 list after emp2 list changed its object"+emp1);
	}
	
	public static void cloningArrayListUsingClonning() {
		List<Employee> emp1=new ArrayList<Employee>();
		emp1.add(new Employee(1,"asdfg"));
		emp1.add(new Employee(2,"qwerty"));
		System.out.println("emp1 list->"+emp1);	
				
		List<Employee> emp2=new ArrayList<Employee>(emp1.size());		
		
		Iterator<Employee> iterator = emp1.iterator();
		while(iterator.hasNext()){
			emp2.add(iterator.next().clone());
		}
		
		emp2.get(0).setName("zxcv");		
		System.out.println("emp1 list after emp2 list changed its object"+emp1);
	}
	public static void main(String[] args) {
		cloningArrayListUsingClonning();
	}

}
