package number_theory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C354 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = (input.readLine()).split(" ");
		int n = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);
		int[] arr = new int[n];
		int min = Integer.MAX_VALUE;
		
		tokens = input.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(tokens[i]);
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		int gcd = min;
		int i=0;
		int debt = 0;
		while(i<n && gcd!=1) {
			int rem = arr[i]%gcd;
			if(rem == 0 || rem<=k)
				i++;
			else if(debt<k){
				gcd--;
				i = 0;
				debt++;
			} else {
				gcd = gcd(min, arr[i]);
				i = 0;
			}
		}
		
		System.out.println(gcd);
	}
	
	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
}
