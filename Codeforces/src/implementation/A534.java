//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A534 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		
		if(n<=2) {
			System.out.println(1);
			System.out.println(1);
		} else if(n==3) {
			System.out.println(2);
			System.out.println("1 3");
		} else {
			System.out.println(n);
			int i = 1;
			int j = n/2 + 1;
			
			int count = 0;
			for(int k=0;k<n;k++) {
				if(k%2==0)
					System.out.print(j++ + " ");
				else 
					System.out.print(i++ + " ");
			}
		}
	}
}
