//AC

import java.io.*;
import java.text.DecimalFormat;
public class ATM {
	public static void main(String args[]) throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String []tokens = input.readLine().split(" ");
			double balance = Double.parseDouble(tokens[1]);
			int wa = Integer.parseInt(tokens[0]);
			if (wa%5==0 && balance>=wa+0.50 && wa!=0)
			{
				System.out.println(balance-wa-0.50);
			}
			else
				System.out.println(balance);
			
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
