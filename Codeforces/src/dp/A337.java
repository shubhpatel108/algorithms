//AC
package dp;

import java.util.Arrays;
import java.util.Scanner;

public class A337 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = input.nextInt();
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		
		for(int i=m-1;i<n;i++)
		{
			if(arr[i]-arr[i-m+1] < min)
				min = arr[i]-arr[i-m+1];
		}
		System.out.println(min);
	}
}
