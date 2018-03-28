package mynotes.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class MapIntermediate {
	
	public static void test1() {
		
		Map<Employee, Employee> map = new HashMap<Employee, Employee>();

		Employee emp1 = new Employee(1, "a");
		Employee emp2 = new Employee(2, "b");
		Employee emp3 = new Employee(3, "c");
		Employee emp33 = new Employee(3, "c");

		map.put(emp1, emp1);
		map.put(emp2, emp2);
		map.put(emp3, emp3);
		map.put(emp33, emp33);

		System.out.println("Map Size =>" + map.size());
		
	}
	
	public static void test2() {
		
		Map<Employee2, Employee2> map = new HashMap<Employee2, Employee2>();

		Employee2 emp1 = new Employee2(1, "a");
		Employee2 emp2 = new Employee2(2, "b");
		Employee2 emp3 = new Employee2(3, "c");
		Employee2 emp33 = new Employee2(3, "c");

		map.put(emp1, emp1);
		map.put(emp2, emp2);
		map.put(emp3, emp3);
		map.put(emp33, emp33);

		System.out.println("Map 2 Size =>" + map.size());
		
	}

	public static void main(String[] args) {
		
		//test1();
		//test2();
		Map<Employee2, Employee2> map = new HashMap<Employee2, Employee2>();

		Employee2 emp1 = new Employee2(1, "a");
		Employee2 emp2 = new Employee2(2, "b");
		Employee2 emp3 = new Employee2(3, "c");
		map.put(emp1, emp1);
		map.put(emp2, emp2);
		map.put(emp3, emp3);
		
		System.out.println("Map 2 Size =>" + map.size());
		
		map.keySet().stream().forEach((key)->{
			//check if key and value points to same thing
			if(key==map.get(key)) {
				System.out.println("key==value"+key + map.get(key));
			}else {
				System.out.println("key!=value"+key + map.get(key));
			}
		});

		
		
		map.get(emp3).setId(4);
		System.out.println("==============Changed object" + map.size());
		
		map.keySet().stream().forEach((key)->{
			//check if key and value points to same thing
			if(key==map.get(key)) {
				System.out.println("key==value"+key + map.get(key));
			}else {
				System.out.println("key!=value"+key + map.get(key));
			}
		});
		
		Employee2 emptemp = map.get(emp3);		
		
		
		boolean exsists = map.containsKey(new Employee2(3, null));
		
		System.out.println("exsists 3 =>" + exsists);
		
		exsists = map.containsKey(new Employee2(4, "c"));
		
		System.out.println("exsists 4 =>" + exsists);		
		
		
		
		
		

	}

}
