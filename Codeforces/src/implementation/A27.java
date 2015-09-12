package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A27 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		boolean[] arr = new boolean[3001];

		for(int i=0;i<n;i++)
			arr[Integer.parseInt(tokens[i])] = true;
		
		int i=1;
		while(i<3001 && arr[i]) {
			i++;
		}

		System.out.println(i);
	}
}
