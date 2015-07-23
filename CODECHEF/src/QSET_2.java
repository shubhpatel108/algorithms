//partially AC, now working for long strings

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QSET_2 {
	public static void main(String args[])throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String toks[];
			toks = input.readLine().split(" ");
			int n = Integer.parseInt(toks[0]);
			int queries = Integer.parseInt(toks[1]);
			int num[] = new int[n];
			int i,start,end, old_val,new_val=0,index, sum, ans=0,j;
			String line = input.readLine();
			num[0] = Integer.parseInt(String.valueOf(line.charAt(0))) % 3;
			for(i=1;i<n;i++)
			{
				num[i] = Integer.parseInt(String.valueOf(line.charAt(i)))%3;
			}
			while(queries-->0)
			{
				toks = input.readLine().split(" ");
				if(Integer.parseInt(toks[0])==2)
				{
					ans = 0;
					start = Integer.parseInt(toks[1])-1;
					end = Integer.parseInt(toks[2])-1;
					for(i=start;i<=end;i++)
					{
						sum = 0;
						for(j=i;j<=end;j++)
						{
							sum +=num[j];
							if(sum%3==0)
								ans++;
						}
					}
					System.out.println(ans);
				}
				else
				{
					index = Integer.parseInt(toks[1])-1;
					new_val = Integer.parseInt(toks[2]);
					num[index] = new_val%3;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
