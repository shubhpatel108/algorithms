package pattern_matching;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class naiveSearch {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String line = input.readLine();
		String pat = input.readLine();
		int n = line.length();
		int m = pat.length();
		for(int i=0;i+m-1<n;i++) {
			int j=0;
			for(;j<m; j++) {
				if(line.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}
			if(j==m) {
				System.out.println("Found pattern starting at : "+i);
			}
		}
	}
}
