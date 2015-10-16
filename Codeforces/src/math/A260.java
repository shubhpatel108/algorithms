//AC
package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A260 {
	static StringBuilder ans;
	static int b;
	static int a;
	
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		
		a = Integer.parseInt(tokens[0]);
		ans = new StringBuilder(tokens[0]);
		b = Integer.parseInt(tokens[1]);
		int n = Integer.parseInt(tokens[2]);
		
		if(isPossible(a%b, n))
			System.out.println(ans.toString());
		else
			System.out.println(-1);
	}
	
	public static boolean isPossible(int num, int n) {
		
		if(n==0)
			return true;
		
		for(int i=0;i<10;i++) {

			int newnum = ((num*10) + i)%b;
//			System.out.println(newnum);
			ans.append(i);
			if(newnum == 0 && isPossible(newnum, n-1))
				return true;
			ans.setLength(ans.length()-1);
		}
		
		return false;
	}
}
