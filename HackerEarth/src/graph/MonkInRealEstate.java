//AC
package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MonkInRealEstate {
	static HashMap<Integer, Boolean> hm;
	
	public static void main(String[] args)throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		
		while(t-->0) {
			String[] tokens = input.readLine().split(" ");
			int m = Integer.parseInt(tokens[0]);

			hm = new HashMap<Integer, Boolean>();
			
			for(int i=0;i<m;i++) {
				tokens = input.readLine().split(" ");
				int u = Integer.parseInt(tokens[0])-1;
				int v = Integer.parseInt(tokens[1])-1;

				if(!hm.containsKey(u)) {
					hm.put(u, true);
				}
				if(!hm.containsKey(v)) {
					hm.put(v, true);
				}
				
			}

			System.out.println(hm.size());
		}
	}

}
