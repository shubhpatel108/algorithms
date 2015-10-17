package Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MonkAndCollison {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			boolean[] num = new boolean[10];
			int col = 0;
			tokens = input.readLine().split(" ");
			for(int i=0;i<n;i++) {
				int ind = Integer.parseInt(tokens[i])%10;
				if(num[ind])
					col++;
				else {
					num[ind] = true;
				}
			}
			
			System.out.println(col);
		}
	}
}
