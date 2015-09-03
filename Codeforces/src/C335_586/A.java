package C335_586;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		

		int last_zero = 0;
		int ans = 0;
		boolean flag = false;

		if(tokens[0].equals("1")) {
			ans++;
			flag = true;
		}
		int i=1;
		while(i<n) {
			if(tokens[i].equals("1")) {
				ans++;
				flag = true;
				if(last_zero==1)
					ans++;
				last_zero = 0;
			} else {
				if(flag) {
					last_zero++;
				}
			}
//			System.out.println(i+" :"+ans);
			i++;
		}

		System.out.println(ans);
	}
}
