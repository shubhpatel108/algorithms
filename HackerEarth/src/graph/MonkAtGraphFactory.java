//AC
package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MonkAtGraphFactory {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		int degreesum = 0;
		tokens = input.readLine().split(" ");

		for(int i=0;i<n;i++) {
			degreesum += Integer.parseInt(tokens[i]);
		}
		
		if(degreesum == 2*(n-1))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
