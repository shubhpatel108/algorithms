//AC
package C316_570;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		String findStr = "..";
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		
		String line = input.readLine();
		char[] s = line.toCharArray();
		int count = 0;
		
		for(int i=0;i<n-1;i++)
			if(s[i]=='.' && s[i+1]=='.')
				count++;
		
		while(m > 0) {
		
			tokens = input.readLine().split(" ");
			int x = Integer.parseInt(tokens[0]) -1;
			char c = tokens[1].charAt(0);
			
			if(c=='.') {
				if(x+1 < n && s[x+1]=='.' && s[x]!='.') {
					count++;
				}
				if(x-1 >=0 && s[x-1]=='.' && s[x]!='.') {
					count++;
				}
			} else {
				if(x+1 < n && s[x+1]=='.' && s[x]=='.') {
					count--;
				}
				if(x-1 >=0 && s[x-1]=='.' && s[x]=='.') {
					count --;
				}
			}
			s[x] = c;
			
			System.out.println(count);
			m--;
		}
	}
}
