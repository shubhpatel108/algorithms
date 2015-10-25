//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C158 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		Shell shell = new Shell();
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			tokens = input.readLine().split(" ");
			
			if(tokens[0].equals("pwd")) {
				shell.pwd(shell.current);
				System.out.println();
			}
			else
				shell.cd(tokens[1]);
		}
	}
}
