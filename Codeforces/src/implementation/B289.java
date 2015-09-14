// of course TLE
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B289 {
	static int[] arr;

	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		int d = Integer.parseInt(tokens[2]);
		
		arr = new int[n*m];

		int count = 0;
		for(int i=0;i<n;i++) {
			tokens = input.readLine().split(" ");
			for(int j=0;j<m;j++) {
				arr[count++] = Integer.parseInt(tokens[j]);
			}
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int ans = minTernarySearch(0, n*m-1, Integer.MAX_VALUE, d);
		
		System.out.println(ans);
	}
	
	public static int effort(int target, int d) {
		int count = 0;
		int length = arr.length;
		for(int i=0;i<length;i++) {
			int diff = Math.abs(target-arr[i])%d;
			if(diff!=0)
				return -1;
			else
				count += Math.abs(target-arr[i])/d;
		}
		return count;
	}
	
	public static int minTernarySearch(int l, int r, int min, int d) {
		if(l>r)
			return min;
		
		int mid1index = l + (r-l)/3;
		int mid2index = mid1index + (r-l)/3;
		
		int mid1 = effort(arr[mid1index], d);
		int mid2 = effort(arr[mid2index], d);
		if(mid1 ==-1 || mid2 == -1)
			return -1;

		System.out.println("mid1 "+ mid1);
		System.out.println("mid2 "+ mid2);

		if(mid1 == mid2)
			return Math.min(mid1, Math.min(minTernarySearch(l, mid2index-1, mid1, d), minTernarySearch(mid1index+1, r, mid2, d)));
		if(mid1 < mid2 && mid1 < min)
			return Math.min(mid1, minTernarySearch(l, mid2index-1, mid1, d));
		else if(mid2 < mid1 && mid2 < min)
			return Math.min(mid2, minTernarySearch(mid1index+1, r, mid2, d));
		else
			return min;
	}
}
