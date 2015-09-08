//TLE
package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B547 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		int arr[] = new int[n];
		String[] tokens = input.readLine().split(" ");
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		for(int k=1;k<=n;k++) {
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for(int i=0;i<k;i++) {
				q.add(arr[i]);
			}
			int max = q.peek();
			int j=k;
			while(j<n) {
				q.add(arr[j]);
				q.remove(arr[j-k]);
				if(q.peek() > max)
					max = q.peek();
				j++;
			}
			System.out.print(max + " ");
		}
	}
}
