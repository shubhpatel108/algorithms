package CodeMonArrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChanduAndConsecutiveLetters {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			StringBuilder s = new StringBuilder();
			String line = input.readLine();
			s.append(line);
			int n = s.length();
			
			for(int i=1;i<n;) {
				if(s.charAt(i)==s.charAt(i-1)) {
					s.deleteCharAt(i);
					n--;
				} else
					i++;
			}
			System.out.println(s.toString());
		}
	}
}
