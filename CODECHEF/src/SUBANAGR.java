//AC
import java.io.*;
import java.util.Arrays;
public class SUBANAGR {
	public static void main(String args[])throws Exception
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(input.readLine());
			String line;
			int i;
			int ans[] = new int[26];
			boolean flag = true;
			boolean flag2 = false;
			
			int temp[];
			while(t-->0)
			{
				temp = new int[26];
				line = input.readLine();
				for(i=0;i<line.length();i++)
				{
					temp[(int)line.charAt(i)-97]++;
					if(flag)
					{
						ans[(int)line.charAt(i)-97]++;
					}
				}
				flag = false;
//				System.out.println();
//				System.out.println(Arrays.toString(temp));

				for(i=0;i<26;i++)
				{
					if(ans[i]!=temp[i])
					{
						ans[i] = (int)Math.min(ans[i], temp[i]);
					}
				}
				
			}
			
			for(i=0;i<26;i++)
			{
				while(ans[i]-->0)
				{
					System.out.print((char)(i+97));
					flag2 = true;
				}
			}
			if(!flag2)
			{
				System.out.print("no such string");
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
