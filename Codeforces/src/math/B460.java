//AC
package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B460 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int a = Integer.parseInt(tokens[0]);
		int b = Integer.parseInt(tokens[1]);
		int c = Integer.parseInt(tokens[2]);
		long x = 0;
		long limit = (long)Math.pow(10, 9);
		ArrayList<Long> list = new ArrayList<Long>();
		
		for(long i=1; i<=81;i++) {
			long ans = b * (long)Math.pow(i, a) + c;
			
			if(ans >0 && ans<limit && sumOfDigits(ans)==i)
				list.add(ans);
		}
		int n = list.size();
		System.out.println(n);
		for(int i=0;i<n;i++)
			System.out.print(list.get(i) + " ");
	}
	
	static int sumOfDigits(long num) {
		int sum = 0;
		while(num > 0) {
			sum += num %10;
			num /= 10;
		}
		return sum;
	}
}
