//TLE
package Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class MonkAndTasks2 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens;
		
		int t = Integer.parseInt(input.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			LinkedHashMap<Integer, ArrayList<Long>> hm = new LinkedHashMap<Integer, ArrayList<Long>>();
			for(int j=0;j<65;j++)
				hm.put(j, new ArrayList<Long>());
			
			tokens = input.readLine().split(" ");
			for(int i=0;i<n;i++) {
				long num = Long.parseLong(tokens[i]);
				int setbits = Long.bitCount(num);
				hm.get(setbits).add(num);
			}

			for(ArrayList<Long> list : hm.values()) {
				for(Long num : list) {
					System.out.print(num+" ");
				}
			}
			System.out.println();
		}
	}
}
