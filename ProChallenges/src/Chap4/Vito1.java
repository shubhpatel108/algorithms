//AC
package Chap4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Vito1 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int T = Integer.parseInt(input.readLine());
		for(int t=0; t<T;t++) {
			String[] tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(tokens[i+1]);
			Arrays.sort(arr);
			int med = arr[n/2];
			int sum = 0;
			for(int i:arr) {
				sum += Math.abs(med - i);
			}
			System.out.println(sum);
		}
	}
}
