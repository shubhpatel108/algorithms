//only addition
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ARHN04 {
	public static void main(String args[])
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String toks[];
			int t = Integer.parseInt(input.readLine());
			String num1,num2;
			int i,j,k;
			String line,ans="";
			int cur_op=-1,carry=0,len1,len2,temp;
			while(t-->0)
			{
				line = input.readLine();
				toks = line.split("[-+]");
				num1 = toks[0];
				cur_op += toks[0].length()+1;
				ans = toks[0];
				for(i=1;i<toks.length;i++)
				{
					ans="";
					num2 = toks[i];
					len1 = num1.length();
					len2 = num2.length();
					if(line.charAt(cur_op)=='+')
					{
						for(j=0,k=0;j<len1 && k<len2;j++,k++)
						{
							
								temp = Integer.parseInt(String.valueOf(num1.charAt(len1-j-1))) + Integer.parseInt(String.valueOf(num2.charAt(len2-k-1))) + carry;
								carry = temp/10;
								temp=temp%10;
								ans = temp + ans;
							
						}
						while(j<len1)
						{
							temp = Integer.parseInt(String.valueOf(num1.charAt(len1-j-1))) + carry;
							carry = temp/10;
							temp=temp%10;
							ans = temp + ans;
							j++;
						}
						while(k<len2)
						{
							temp = Integer.parseInt(String.valueOf(num2.charAt(len2-j-1))) + carry;
							carry = temp/10;
							temp=temp%10;
							ans = temp + ans;
							k++;
						}
						num1 = ans;
						if(carry!=0)
							ans = carry + ans;
						
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
