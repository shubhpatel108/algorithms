package RoundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		for(int i=1;i<=t;i++) {
			long k = Long.parseLong(input.readLine());
			char ans = '0';
			if(k == (long)(Math.log(k)/Math.log(2)) * 2) {
				ans = '0';
			} else {
				ans = sGoogol(k, getLength(k,0));
			}
			System.out.println("Case #"+i+": "+ans);
		}
	}
	
	public static char sGoogol(long k, long n) {
		if(k==1)
			return '0';
//		System.out.println("k :" + k);
//		System.out.println("n :" + n);
//		System.out.println(n);
		
		long middle = n/(long)2 + 1;
		if(k == middle)
			return '0';
		else if(k < middle) {
			return sGoogol(k, middle-1);
		} else {
			return inverse(sGoogol(n-k+1, middle-1));
		}
	}
	
	public static long getLength(long k, long n) {
		if(n>=k)
			return n;
		else
			return getLength(k, n*2 + 1);
	}
	
	public static char inverse(char c) {
		switch(c) {
			case '0':
				return '1';
			default:
				return '0';
		}
	}
}
