package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A500 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);
		
		int[] arr = new int[n];
		tokens = input.readLine().split(" ");
		for(int i=1;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i-1]);
		
		boolean possible = isPossible(arr, k);
		if(possible)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	public static boolean isPossible(int[] arr, int k) {
		int n = arr.length;
		int i = 1;
		for(;i<n;) {
			if(i==k)
				return true;
			else if(i>k)
				return false;
			else
				i += arr[i];
		}
		return i==k;
	}
}
