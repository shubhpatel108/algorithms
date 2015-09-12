//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A381 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		
		int[] arr = new int[n];
		tokens = input.readLine().split(" ");
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		int turn = 0;
		int i=0,j=n-1;
		int sum1 = 0;
		int sum2 = 0;
		
		while(i<=j) {
			int take = 0;
			if(arr[i]>arr[j]) {
				take = arr[i];
				i++;
			} else {
				take = arr[j];
				j--;
			}
			if(turn%2==0)
				sum1 += take;
			else
				sum2 += take;
			turn++;
		}
		System.out.println(sum1 +" "+ sum2);
	}
}
