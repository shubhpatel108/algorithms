//D570
//Incomplete
package C316_570;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D {
	static char c[][];
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int m = Integer.parseInt(tokens[0]);
		int n = Integer.parseInt(tokens[1]);
		
		c = new char[m][n];
		
		for(int i=0;i<n;i++) {
			String line = input.readLine();
			for(int j=0;j<n;j++) {
				c[i][j] = line.charAt(j);
			}
		}
		
		StringBuilder s = new StringBuilder();
		for(int i=0;i<m;i++)
			s.append(c[i][0]);
		for(int i=0;i<n;i++)
			s.append(c[0][i]);
		
		boolean[] initial = nonPalin(s.toString());
		boolean ifpalin = false;
		for(boolean b:initial)
			ifpalin = ifpalin || b;
		
		long ans = 0;
		if(!ifpalin)
			ans++;
		
//		ans += total(s, 0, 0, m, n);
		
		System.out.println();
	}
	
	public static boolean[] nonPalin(String line) {
		int n = line.length();
		int i=0, j=n-1;
		boolean[] arr = new boolean[n];
		while(i<j) {
			if(line.charAt(i) == line.charAt(j))
			{
				i++;
				j--;
			} else {
				arr[i] = true;
				arr[j] = true;
			}
		}
		return arr;
	}
	
//	public static long total(StringBuilder path, int i, int j, int m, int n) {
//		
//	}
}
