package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B443 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		long[] orig = new long[n];
		
		for(int i=0;i<n;i++)
			orig[i] = Integer.parseInt(tokens[i]);
		long[] sorted = orig.clone();
		long[] arr = orig.clone();
		
		Arrays.sort(sorted);
		for(int i=1;i<n;i++) {
			arr[i] += arr[i-1];
			sorted[i] += sorted[i-1];
		}
		
		int k = Integer.parseInt(input.readLine());
		while(k-->0) {
			tokens= input.readLine().split(" ");
			int l = Integer.parseInt(tokens[1]) - 1;
			int r = Integer.parseInt(tokens[2]) - 1;
			long ans = 0;
			if(tokens[0].equals("1")) {
				ans = arr[r] - arr[l] + orig[l];
			} else {
				ans = sorted[r] - sorted[l];
				if(l==0) {
					ans += sorted[0];
				} else {
					ans += sorted[l] - sorted[l-1];
				}
			}
			System.out.println(ans);
		}
	}
}
