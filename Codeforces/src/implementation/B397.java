//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B397 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int T = Integer.parseInt(input.readLine());
		for(int t=0; t<T;t++) {
			int n = 3;
			int[] arr = new int[n];
			String[] tokens = input.readLine().split(" ");
			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(tokens[i]);
			
			boolean possible = isPossibleSum(arr[1], arr[2], arr[0]);
			if(possible)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
	
	public static boolean isPossibleSum(int l, int r, int n) {
		int k = n / r + 1;
		
		if(n%l==0 || n%r==0 || (n%l)%r==0 || (n%r)%l==0) {
            return true;
        }
		if(l*k < n && r*k>n)
			return true;
		else
			return false;
	}
}
