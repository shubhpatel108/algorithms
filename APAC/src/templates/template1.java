package templates;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class template1 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int T = Integer.parseInt(input.readLine());
		
//		String[] tokens = input.readLine().split(" ");
		
		for(int t=1;t<=T;t++) {
			//solve
			System.out.println("Case #"+t+":");
		}
	}
}
