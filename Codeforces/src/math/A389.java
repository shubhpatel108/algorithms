//AC
package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A389 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		int[] arr = new int[101];

		for(int i=0;i<n;i++)
			arr[Integer.parseInt(tokens[i])]++;
		
		int j=99, i=100;
		
		while(i>0 && j>0) {
			

			while(i>0 && arr[i]==0)
				i--;

			j = i-1;

			while(j>0 && arr[j]==0)
				j--;

			if(i==0 || j==0)
				break;
			
			if(i%j == 0)
				arr[j] += arr[i];
			else
				arr[i%j] += arr[i];
			
			arr[i] = 0;
			i = j;
			j--;
		}
		
		int sum = 0;
		for(i=1;i<=100;i++) {
			sum += i*arr[i];
		}

		System.out.println(sum);
	}
}
