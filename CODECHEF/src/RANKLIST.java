import java.io.*;

public class RANKLIST {
	public static void main(String args[])throws Exception
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader (System.in));
			int t = Integer.parseInt(input.readLine());
			String toks[];
			while(t-->0)
			{
				toks = input.readLine().split(" ");
				long n = Integer.parseInt(toks[0]);
				long s = Integer.parseInt(toks[1]);
				long sum = (n*(n+1))/2;
				long remaining = s-n;
				if(n==s)
				{
					System.out.println(n-1);
				}
				else if(sum==s)
				{
					System.out.println(0);	
				}
				else
				{
					sum = (n*(n-1))/2;
					double temp = (int)(Math.sqrt(1+4*(sum-remaining)));
					int root = (int) (((temp+1)/2));
//					System.out.println("root::"+root);
//					long ans = n-1-root;
//					if(((root*(root+1))/2)>remaining)
//						ans = ans + 1;
					System.out.println(root);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
