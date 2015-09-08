//TLE
package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B547_2 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		int arr[] = new int[n];
		String[] tokens = input.readLine().split(" ");
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(tokens[i]);
			if(arr[i] > max)
				max = arr[i];
		}
		System.out.print(max + " ");
		for(int k=1;k<n;k++) {
			max = Integer.MIN_VALUE;
			for(int i=0;i<n-k;i++) {
				arr[i] = Math.min(arr[i], arr[i+1]);
				if(arr[i] > max) {
					max = arr[i];
				}
			}
			System.out.print(max +" ");
		}
	}
}
