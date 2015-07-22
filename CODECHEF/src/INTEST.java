//AC with Execution Time: 8.07!!

import java.io.*;
public class INTEST {
	public static void main(String args[]) throws Exception
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String line = input.readLine();
			int count = 0;
			String []tokens = line.split(" ");
			int n = Integer.parseInt(tokens[0]);
			int k = Integer.parseInt(tokens[1]);
			while(n-->0)
			{
				if(Integer.parseInt(input.readLine())%k==0)
					count++;
				
			}
			System.out.println(count);	
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
