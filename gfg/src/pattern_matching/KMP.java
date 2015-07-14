package pattern_matching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KMP {
	static int lps[];
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String line = input.readLine();
		String pat = input.readLine();
		int n = line.length();
		int m = pat.length();
		findLPS(pat);
		
		
		int i=0, j=0;
		while(i<n) {
			if(line.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			if(j == m) {
				System.out.println("Found pattern occ. at " +(i-m));
				j = lps[j-1];
			} else if(i<n && line.charAt(i)!=pat.charAt(j)){
				if(j!=0)
					j = lps[j-1];
				else
					i++;
			}
		}
	}
	
	public static void findLPS(String pat) {
		int m = pat.length();
		lps = new int[m];
		int i=1, len = 0;
		lps[0] = 0;
		while(i<m) {
			if(pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if(len == 0) {
					lps[i] = 0;
					i++;
				} else {
					len = lps[len-1];
				}
			}
		}
	}
}
