//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A69 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		int[] sum = new int[3];
		
		for(int i=0;i<n;i++) {
			String[] tokens = input.readLine().split(" ");
			for(int j=0;j<3;j++) 
				sum[j] += Integer.parseInt(tokens[j]);
		}
		boolean flag = true;
		for(int i=0;i<3;i++) {
			if(sum[i]!=0) {
				flag = false;
				break;
			}
		}
		if(flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
