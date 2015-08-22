package hack101sep;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class binarygift {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String a = input.readLine();
		String b = input.readLine();
		int la = a.length();
		int lb = b.length();

		int diff = 0;

		int ans = 0;
		
		if(la!=lb)
			ans = -1;
		else {
			for(int i=0;i<la;i++) {
				if(a.charAt(i)!=b.charAt(i))
					diff++;
			}
			
			if(diff%2!=0)
				ans = -1;
			else
				ans = diff/2;
		}
		System.out.println(ans);
	}
}
