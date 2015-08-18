package CodeMonArrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrateekAndHisFriends {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			long req = Long.parseLong(tokens[1]);
			
			int[] arr = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(input.readLine());
			}
			
			int i=0,j=0;
			long sum = arr[0];
			boolean ans = false;

			while(i<n && j<n) {
				if(sum == req) {
					ans = true;
					break;
				} else if(sum < req) {
					j++;
					if(j<n)
						sum += arr[j];
					else {
						ans = false;
						break;
					}
				} else {
					sum -= arr[i];
					i++;
				}
			}
			if(sum == req)
				ans = true;
			
			System.out.println(ans(ans));
		}
	}
	
	public static String ans(boolean ans) {
		if(ans)
			return "YES";
		else
			return "NO";
	}
}
