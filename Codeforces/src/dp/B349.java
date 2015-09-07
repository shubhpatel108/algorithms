//AC
package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B349 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		int arr[] = new int[9];
		String[] tokens = input.readLine().split(" ");
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(tokens[i]);
		}
		int min = minNum(arr);
		StringBuilder ans = new StringBuilder();
		if(arr[min-1] > n) {
			System.out.println(-1);
		} else {
			int num = n / arr[min-1];
			while(num > 0) {
				ans.append(min);
				num--;
			}
			int rem = n % arr[min-1];
			int i = 8;
			StringBuilder append = new StringBuilder();

			while(i>min-1 && rem>0) {
				int x = rem/(arr[i]-arr[min-1]);
				rem -= (arr[i]-arr[min-1]) * x;
				while(x-->0) {
					append.append(i+1);
				}
				i--;
			}
			System.out.print(append.toString());
			System.out.println(ans.substring(append.length(), ans.length()));
		}
		
	}
	
	public static int minNum(int arr[]) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		int n = arr.length;
		int i = 0;
		for(;i<n;i++) {
			if(arr[i]<=min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex+1;
	}

}
