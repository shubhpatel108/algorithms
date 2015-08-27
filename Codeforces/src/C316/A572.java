//AC
package C316;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A572 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[1]);
		tokens = input.readLine().split(" ");
		int k = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		
		tokens = input.readLine().split(" ");
		int l = Integer.parseInt(tokens[k-1]);

		tokens = input.readLine().split(" ");
		int r = Integer.parseInt(tokens[n-m]);
		
		if(l<r)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
