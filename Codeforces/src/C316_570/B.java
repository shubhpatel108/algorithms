//AC
package C316_570;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		long n = Long.parseLong(tokens[0]);
		long m = Long.parseLong(tokens[1]);
		
		long ans = 0;
		if(n==1)
			ans = 1;
		else if(n-m > m-1) {
			ans = m+1;
		} else {
			ans = m-1;
		}
		System.out.println(ans);
	}
}
