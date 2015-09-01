//AC
package C321_580;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		int last_max = 1;
		int max = 1;
		
		for(int i=1;i<n;i++) {
			if(arr[i] >= arr[i-1]) {
				last_max++;
			} else {
				last_max = 1;
			}

			max = Math.max(last_max, max);
		}
		
		System.out.println(max);
	}
}
