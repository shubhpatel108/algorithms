//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B266 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int t = Integer.parseInt(tokens[1]);
		
		String s = input.readLine();
		StringBuilder q = new StringBuilder(s);
		for(int i=0;i<t;i++) {
			StringBuilder newq = new StringBuilder();
			newq.append(q.charAt(0));
			for(int j=1;j<n;j++) {
				if(q.charAt(j) == 'G' && q.charAt(j-1) == 'B') {
					newq.insert(j - 1, 'G');
				} else if(q.charAt(j) == 'G') {
					newq.append('G');
				}else {
					newq.append('B');
				}
			}
			q = newq;
		}
		System.out.println(q.toString());
	}
}
