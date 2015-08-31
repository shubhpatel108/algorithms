package C320;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A578 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		int ans = 0;
		
		while(n>0) {
			int x = count(n);
//			System.out.println(x);
			n -= x;
			ans++;
		}
		System.out.println(ans);
	}
	
	public static int count(int n) {
		return (int)Math.pow(2, (int)(Math.log10(n) / Math.log10(2)));
	}
}
