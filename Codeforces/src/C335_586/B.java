package C335_586;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		int[][] arr = new int[2][n];
		int[] main = new int[n];

		String[] tokens = input.readLine().split(" ");
		for(int i=1;i<n;i++)
			arr[0][i] = Integer.parseInt(tokens[i-1]);
		
		tokens = input.readLine().split(" ");
		for(int i=0;i<n-1;i++)
			arr[1][i] = Integer.parseInt(tokens[i]);
		
		tokens = input.readLine().split(" ");
		for(int i=0;i<n;i++)
			main[i] = Integer.parseInt(tokens[i]);
		
		
		for(int i=1;i<n;i++) {
			arr[0][i] += arr[0][i-1];
		}
		for(int i=n-2;i>=0;i--) {
			arr[1][i] += arr[1][i+1];
		}

		
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;

		for(int i=0;i<n;i++) {
			int cost = arr[0][i] + arr[1][i] + main[i];
//			System.out.println(cost);
			
			if(cost < min1) {
				min2 = min1;
				min1 = cost;
			} else if(cost < min2)
				min2 = cost;
		}
		
		System.out.println(min1 + min2);
	}
}
