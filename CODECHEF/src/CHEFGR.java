//AC
import java.io.*;

public class CHEFGR {
	public static void main(String args[])throws Exception
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(input.readLine());
			String toks[];
			int n,m,sum=0,i,temp;
			while(t-->0)
			{
				sum=0;
				toks = input.readLine().split(" ");
				n = Integer.parseInt(toks[0]);
				m = Integer.parseInt(toks[1]);
				toks = input.readLine().split(" ");
				for(i=0;i<n;i++)
				{
					sum+=Integer.parseInt(toks[i]);
				}
				temp = (sum+m)/n;
				if((sum+m)%temp==0)
				{
					System.out.println("Yes");
				}
				else 
					System.out.println("No");
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
