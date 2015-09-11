//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A149 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int k = Integer.parseInt(tokens[0]);
		
		int[] arr = new int[12];
		tokens = input.readLine().split(" ");
		for(int i=0;i<12;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		Arrays.sort(arr);
		for(int i=0;i<6;i++)
		{
			int temp = arr[i];
			arr[i] = arr[12-i-1];
			arr[12-i-1] = temp;
		}
		
		int total = 0;
		int i=0;
		
		while(i<12 && total < k) {
			total += arr[i];
			i++;
		}
		if(i==12 && total<k)
			System.out.println(-1);
		else
			System.out.println(i);
	}
}
