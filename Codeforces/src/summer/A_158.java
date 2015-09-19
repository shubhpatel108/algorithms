//AC
package summer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_158 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String tokens[] = (input.readLine()).split(" ");
		int n = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);
		tokens = (input.readLine()).split(" ");
		int i=0;
		int ans = 0, temp, compTo = Integer.parseInt(tokens[k-1]);
		while(i<n)
		{
			temp = Integer.parseInt(tokens[i]);
			if(temp>0 && temp>=compTo)
				ans++;
			else if(temp>compTo)
				break;
			i++;
		}
		System.out.println(ans);
	}
}
