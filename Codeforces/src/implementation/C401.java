//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C401 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);

		if(n > m+1 || m>2*(n+1)) {
			System.out.println(-1);
		} else {
			StringBuilder buf = new StringBuilder();
			String zero = "0";
			String one = "1";
			String done = "11";

			if(n>=m) {
				while(m-->0) {
					buf.append(zero);
					buf.append(one);
					n--;
				}
				if(n>0)
					buf.append(zero);
			} else {
				int extra = m - (n+1);
				
				while(extra-->0) {
					buf.append(done);
					m -= 2;
					if(n>0) {
						buf.append(zero);
						n--;
					}
				}

				while(m-->0) {
					buf.append(one);
					if(n>0) {
						buf.append(zero);
						n--;
					}
				}
			}
			System.out.println(buf.toString());
		}
	}
}
