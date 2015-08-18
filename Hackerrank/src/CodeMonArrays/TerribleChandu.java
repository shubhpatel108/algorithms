package CodeMonArrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TerribleChandu {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			String line = input.readLine();
			int n = line.length();
			
			for(int i=n-1;i>=0;i--) {
				System.out.print(line.charAt(i));
			}
			System.out.println();
		}
	}
}
