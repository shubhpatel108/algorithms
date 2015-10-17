//AC
package Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MonkInLandOfPokemons {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			int food = 0;
			
			while(n-->0) {
				tokens = input.readLine().split(" ");
				int f = Integer.parseInt(tokens[0]);
				int p = Integer.parseInt(tokens[1]);
				
				if(f==p)
					continue;
				
				if(hm.containsKey(f))
					hm.put(f, hm.get(f) + 1);
				else
					hm.put(f, 1);
				
				if(hm.containsKey(p) && hm.get(p)>0) {
					hm.put(p, hm.get(p)-1);
				} else {
					food++;
				}
			}
			System.out.println(food);
		}
	}
}
