//AC
package C316_570;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		
		int[] won = new int[n];
		
		for(int i=0;i<m;i++) {
			int max = Integer.MIN_VALUE;
			int minIndex = -1;
			tokens = input.readLine().split(" ");
			for(int j=0;j<n;j++) {
				if(Integer.parseInt(tokens[j]) > max) {
					max = Integer.parseInt(tokens[j]);
					minIndex = j;
				}
			}
			won[minIndex]++;
//			System.out.println(Arrays.toString(won));
		}
		
		int max = Integer.MIN_VALUE;
		int minIndex = -1;
		for(int j=0;j<n;j++) {
			if(won[j] > max) {
				max = won[j];
				minIndex = j;
			}
		}
		System.out.println(minIndex + 1);
	}
}
