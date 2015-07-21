//AC ET:3.98

import java.io.*;
public class FCTRL {
	public static void main(String args[]) throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(input.readLine());
			int num,i,count=0;
			while(n-->0)
			{
				num = Integer.parseInt(input.readLine());
				for(i=5;num/i>=1;i*=5)
				{
					count += num/i;
				}
				System.out.println(count);
				count=0;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
