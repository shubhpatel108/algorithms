//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class A158 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);
		int[] arr = new int[n];
		tokens = input.readLine().split(" ");
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		int ans = 0;
		if(arr[k-1]==0) {
			for(int i=0;i<k;i++)
				if(arr[i]!=0)
					ans++;
		} else {
			ans = k;
			int i = k;
			while(i<n && arr[i]==arr[k-1]) {
				ans++;
				i++;
			}
		}
		System.out.println(ans);
	}
}
