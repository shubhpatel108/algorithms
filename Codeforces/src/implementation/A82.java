//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A82 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		int sum = 0;
		int pow = 0;
		while(true) {
			int add = (int)Math.pow(2, pow) * 5;
			if(sum + add > n) {
				break;
			} else {
				sum += add;
				pow++;
			}
		}
		n -= sum;
		int ans = (int)Math.ceil(n / Math.pow(2, pow));
		System.out.println(person(ans));
	}
	
	public static String person(int index) {
		switch(index) {
		case 1:
			return "Sheldon";
		case 2:
			return "Leonard";
		case 3:
			return "Penny";
		case 4:
			return "Rajesh";
		default:
			return "Howard";
		}
	}
}
