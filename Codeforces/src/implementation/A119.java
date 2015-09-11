//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A119 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		int a = Integer.parseInt(tokens[0]);
		int b = Integer.parseInt(tokens[1]);
		int n = Integer.parseInt(tokens[2]);
		
		int turn = -1;
		
		while(n>0) {
			turn++;
			int rem = 0;
			if(turn%2==0) {
				rem = gcd(n, a);
//				System.out.println("GCD: " + n + " and " + a +" is: " + rem);
				if(n<rem)
					break;
			} else {
				rem = gcd(n, b);
//				System.out.println("GCD: " + n + " and " + b +" is: " + rem);
				if(n<rem)
					break;
			}
			n -= rem;
//			System.out.println(rem);
		}
		if(turn%2==0)
			System.out.println("0");
		else
			System.out.println("1");
	}
	
	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
}
