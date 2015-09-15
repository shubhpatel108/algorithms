package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C268 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		int min = Math.min(m,n);
		
		System.out.println(min +1);
		for(int i=0;i<=min;i++) {
			System.out.println(i + " " + i);
		}
		
		System.out.println();
	}
}
