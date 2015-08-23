package morganstanley15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinTransformationCost {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			String s1 = input.readLine();
			String s2 = input.readLine();
			int[] arr1 = new int[26];
			int[] arr2 = new int[26];
			
			int l1 = s1.length();
			int l2 = s2.length();
			
			for(int i=0;i<l1;i++)
				arr1[Character.toLowerCase(s1.charAt(i))-97]++;
			
			for(int i=0;i<l2;i++)
				arr2[Character.toLowerCase(s2.charAt(i))-97]++;

			long f = 0;
			long s = 0;
			for(int i=0;i<26;i++) {
				if(arr1[i] > arr2[i]) {
					f += (arr1[i]-arr2[i]);
				} else if(arr1[i] < arr2[i]) {
					s += (arr2[i]-arr1[i]);
				}
			}

			tokens = input.readLine().split(" ");
			long a = Integer.parseInt(tokens[0]);
			long b = Integer.parseInt(tokens[1]);
			long c = Integer.parseInt(tokens[2]);
			
			long cost = 0;

			long min = Math.min(f,s);
			f -= min;
			s -= min;
			
			cost = Math.min(a+b, c)*min;
			cost += f*a + s*b;
			
			System.out.println(cost);
		}
	}
}
