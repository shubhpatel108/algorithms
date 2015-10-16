//AC
package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A224 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = 3;

		String[] tokens = input.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		long subsuq = 1;
		for(int num : arr)
			subsuq *= num;
		
		int a = (int)Math.sqrt(subsuq / (arr[0]*arr[0]));
		int b = (int)Math.sqrt(subsuq / (arr[1]*arr[1]));
		int c = (int)Math.sqrt(subsuq / (arr[2]*arr[2]));
		
		System.out.println(4*(a+b+c));
	}
}
