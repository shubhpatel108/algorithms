//AC ET: 0.40

import java.io.*;
import java.math.BigInteger;
public class FCTRL2 {
	public static void main(String args[])throws Exception
	{
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(input.readLine());
			BigInteger ans;
			int i,num;
			while(n-->0)
			{
				num = Integer.parseInt(input.readLine());
				if(num==0)
					ans = BigInteger.valueOf(1);
				else
				{
					ans = BigInteger.valueOf(1);
					for(i=1;i<=num;i++)
					{
						ans = ans.multiply(BigInteger.valueOf(i));
					}
				}
				System.out.println(ans);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
