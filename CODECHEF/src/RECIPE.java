import java.io.BufferedReader;
import java.io.InputStreamReader;
public class RECIPE {
	public static void main(String args[])throws Exception
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(input.readLine());
			String toks[];
			int n,i;
			int num[];
			while(t-->0)
			{
				toks = input.readLine().split(" ");
				n = Integer.parseInt(toks[0]);
				num = new int[n];
				for(i=0;i<n;i++)
				{
					num[i] = Integer.parseInt(toks[i+1]);
				}
				int temp = gcd(num[0], num[1]);
				for(i=2;i<n;i++)
				{
					if(temp>=num[i])
						temp = gcd(temp, num[i]);
					else
						temp = gcd(num[i], temp);
				}
				for(i=0;i<n;i++)
					System.out.print(num[i]/temp + " ");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static int gcd(int a, int b)
	{
		try
		{
			if(b==0) return a;
			return gcd(b,a%b);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return 0;
		}
	}
}
