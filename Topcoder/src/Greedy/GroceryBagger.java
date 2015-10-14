//AC
package Greedy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GroceryBagger {
	public int minimumBags(int strength, String[] itemType) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String s : itemType) {
			if(map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else
				map.put(s, 1);
		}
		int total = 0;
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			total += Math.ceil((double)entry.getValue() / strength);
		}
		return total;
	}
}
