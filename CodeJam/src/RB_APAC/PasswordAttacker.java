//WA
package RB_APAC;

import java.util.Scanner;

public class PasswordAttacker {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		for(int t=1; t<=T; t++) {
			int m = input.nextInt();
			int n = input.nextInt();
			
			int rem = n-m;
			long ans = 0;
			int multiplier = 2;
			if(m==1)
				multiplier = 1;
			if(rem>0) {
				ans = factorial(m) * multiplier * remSeats(m, rem);
			} else {
				ans = factorial(m);
			}
			System.out.println("Case #"+t+": " + ans);
		}
	}
	
	static long remSeats(int m, int num) {
		return (long)Math.pow(m, num);
	}
	
	static long factorial(long num) {
		if(num==0)
			return 1;
		return (num * factorial(num-1)) % (1000000007);
	}
}
