package mynotes.collections.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapBasics {

	public static void main(String[] args) {
		Map<Integer, String> myMap = new HashMap<Integer, String>();
		myMap.put(1, "One");
		myMap.put(2, "Two");
		myMap.put(3, "Three");

		String value = (String) myMap.get(2);
		System.out.println(value);

		// key iterator
		Iterator<Integer> keyIterator = myMap.keySet().iterator();
		System.out.println("Keys:");
		while (keyIterator.hasNext()) {
			Integer keys = (Integer) keyIterator.next();
			System.out.println(keys);

		}
		// value iterator
		Iterator<String> valueIterator = myMap.values().iterator();
		System.out.println("Values:");
		while (valueIterator.hasNext()) {
			String values = (String) valueIterator.next();
			System.out.println(values);

		}
		
		//looping using For
		System.out.println("Values by for loop:");
		for(Integer key : myMap.keySet()) {
		    Object obj = myMap.get(key);
		    System.out.println(obj);
		}
		
		//removing item the wrong way
		/*for(Integer key : myMap.keySet()) {
		    if(key==2){
		    	myMap.remove(key);
		    }
		}*/
		
		//removing using iterator
		Iterator<Integer> interatorToRemove=myMap.keySet().iterator();
		while (interatorToRemove.hasNext()) {
			Integer integer = (Integer) interatorToRemove.next();
			if(integer==2){
				interatorToRemove.remove();
				System.out.println("Removed");
			}
			
		}

	}

}
