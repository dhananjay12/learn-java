package mynotes.collections.maps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapComputeMethod {
	
	public static void main(String[] args) {
		Map<Integer, String> map = new ConcurrentHashMap<>();
		map.put(1, "Java");
		map.put(2, "Java");
		
		System.out.println("Original map: " + map);

		// recompute the values:
		map.compute(1, (key, oldVal) -> oldVal.concat("Script"));
		map.compute(2, (key, oldVal) -> oldVal.concat("FrameWork"));
		System.out.println("Recomputed map: " + map);

		// return "null" to remove value:
		String r1 = map.compute(1, (key, oldVal) -> null);
		System.out.println("Recomputed again with null: " + r1);
		System.out.println("Recomputed map: " + map);
		
		// null for does nothing:
		String r2 = map.compute(3, (key, oldVal) -> null);
		System.out.println("Tried adding a value null with different key with null: " + r2);
		System.out.println("Map: " + map);
		
		//new key added
		String r3 = map.compute(4, (key, oldVal) -> "Spring");
		System.out.println("tried adding a value null with different key with null: " + r3);
		System.out.println("Recomputed Map: " + map);
	}

}
