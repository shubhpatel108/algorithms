package C321_580;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		int d = Integer.parseInt(tokens[1]);
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		System.out.println();
	}
}
