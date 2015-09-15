//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B552 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		long n = Integer.parseInt(tokens[0]);
		int digits = numOfDigits(n);
		long ceilDigit = 11;
		int count = digits;
		while(count > 1) {
			ceilDigit += (9 * (long)Math.pow(10, count-1)) * count + 1;
			count--;
		}
		long ans = ceilDigit - (long)(Math.pow(10, digits) - n) * digits - 1;
		System.out.println(ans);
	}
	
	public static int numOfDigits(long num) {
		int digits = 0;
		while(num > 0) {
			num /= 10;
			digits++;
		}
		return digits;
	}
}
