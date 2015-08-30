//AC
package C318_574;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		long[] arr = new long[n];
		for(int i=0;i<n;i++)
			arr[i] = Long.parseLong(tokens[i]);
		
		long lcm = lcm(arr);

		boolean a = true;

		for(int i=0;i<n;i++) {
			if(lcm%arr[i]!=0) {
				a = false;
				break;
			}
			if(!ans(lcm / arr[i])) {
				a = false;
				break;
			}
		}
		
		if(a)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	
	static boolean ans(long lcm) {
		while(lcm%2==0) {
			lcm /= 2;
		}
		while(lcm%3==0) {
			lcm /= 3;
		}
		return lcm == 1;
	}
	
	private static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}

	private static long gcd(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
	    return result;
	}
	
	private static long lcm(long a, long b)
	{
		long temp = a*b;
	    return a * (b / gcd(a, b));
	}

	private static long lcm(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}
}
