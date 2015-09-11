//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A110 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String n = input.readLine();
		int length = n.length();
		int count = 0;
		
		for(int i=0;i<length;i++)
			if(n.charAt(i)=='4' || n.charAt(i)=='7')
				count++;
		
		if(isLucky(String.valueOf(count))) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	public static boolean isLucky(String num) {
		int n = num.length();
		for(int i=0;i<n;i++) {
			char c = num.charAt(i);
			if(c!='4' && c!='7')
				return false;
		}
		return true;
	}
}
