//WA
package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class B476 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String s1 = input.readLine();
		String s2 = input.readLine();
		int dist1 = 0;
		int dist2 = 0;
		int unknown = 0;
		int n= s1.length();
		for(int i=0;i<n;i++) {
			if(s1.charAt(i) == '+')
				dist1++;
			else
				dist1--;
			
			if(s2.charAt(i) == '+')
				dist2++;
			else if(s2.charAt(i) == '-')
				dist2--;
			else
				unknown++;
		}
		double prob = 0;
		int diff = Math.abs(dist1 - dist2);
		if(diff==0 && unknown==0)
			prob = 1;
		else if(diff>unknown) {
			prob = 0;
		}
		else {
			prob = Math.pow(0.5, unknown-diff) * 2;
			unknown -= diff;
			if(unknown%2!=0)
				prob = 0;
			else {
				double numer = 1;
				double deno = 1;
				int m = unknown;
				while(m>unknown/2) {
					numer *= m;
					m--;
				}
				m = unknown/2;
				while(m>0) {
					deno *= m;
					m--;
				}
				prob *= (numer/deno) / Math.pow(2, unknown) * 2;
			}
		}
		System.out.println(new DecimalFormat("#0.000000000000").format(prob));
	}
}
