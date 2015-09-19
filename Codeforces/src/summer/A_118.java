package summer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_118 {
	public static void main(String args[])throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		String line = input.readLine();
		int len = line.length();
		char c;
		String ans="";
		while(i<len) {
			c = Character.toLowerCase(line.charAt(i));
			if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u' && c!='y')
			{
				ans += "." + String.valueOf(c);
			}
			i++;
		}
		System.out.println(ans);
	}
}
