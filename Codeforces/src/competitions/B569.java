//A
package competitions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B569 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		
		int[] arr = new int[n+1];
		boolean[] occ = new boolean[n+1];
		
		tokens = input.readLine().split(" ");
		
		for(int i=1;i<=n;i++) {
			int index = Integer.parseInt(tokens[i-1]);
			if(index<=n && !occ[index]) {
				occ[index] = true;
				arr[i] = index;
			}
		}
		int i=1;
		int j=1;
		while(j<=n) {
			while(i<=n && arr[i]!=0) {
				i++;
			}
			if(i==n+1)
				break;
			
			j = findNextFree(occ, j);
			arr[i] = j;
			occ[j] = true;
		}
		
		for(int m=1;m<=n;m++) {
			System.out.print(arr[m]+" ");
		}
	}
	
	public static int findNextFree(boolean[] occ, int i) {
		int n = occ.length;
		while(i<n && occ[i])
			i++;
		
		return i;
	}
}
