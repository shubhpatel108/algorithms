//AC
package dp;

import java.util.ArrayList;
import java.util.Scanner;

public class B538 {
	static ArrayList<String> ans = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		convert(n);
		System.out.println(ans.size());
		for(String s:ans) {
			System.out.print(s + " ");
		}
	}
	
	public static void convert(int n) {
		if(n==0)
			return;
		String num = String.valueOf(n);
		int l = num.length();
		StringBuilder buf = new StringBuilder();
		int i=0;
		while(num.charAt(i)=='0')
			i++;
		
		for(;i<l;i++) {
			char c = num.charAt(i);
			if(c=='0')
				buf.append(c);
			else
				buf.append('1');
		}
		ans.add(buf.toString());
		convert(n - Integer.parseInt(buf.toString()));
	}
}
