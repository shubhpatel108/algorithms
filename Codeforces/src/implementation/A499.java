//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A499 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		int x = Integer.parseInt(tokens[1]);
		
		int cur = 1;
		int total = 0;
		
		while(n-->0) {
			tokens = input.readLine().split(" ");
			int l = Integer.parseInt(tokens[0]);
			int r = Integer.parseInt(tokens[1]);
			
			while(cur+x <= l) {
				cur += x;
			}
			total += (l-cur);
			total += (r-l + 1);
			cur = r + 1;
		}
		System.out.println(total);
	}
}
