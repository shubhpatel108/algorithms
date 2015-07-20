import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CHEFSTON {
	public static void main(String args[])throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int m = Integer.parseInt(input.readLine());
			String line;
			String toks[];
			int n;
			long k;
			int i;
			long max;
			
			while(m-->0)
			{
				max = 0;
				line = input.readLine();
				toks = line.split(" ");
				n = Integer.parseInt(toks[0]);
				k = Long.parseLong(toks[1]);
				long time[] = new long[n];
				long profit[] = new long[n];
				toks = input.readLine().split(" ");
				for(i=0;i<n;i++)
					time[i] = Long.parseLong(toks[i]);
				toks = input.readLine().split(" ");
				for(i=0;i<n;i++)
					profit[i] = Long.parseLong(toks[i]);
				for(i=0;i<n;i++)
				{
					if(time[i]!=0)
					{
						if(max < ((long)Math.floor(k/time[i]))*profit[i])
						{
							max = (long)Math.floor(k/time[i]) * profit[i];
						}
					}
				}
				System.out.println(max);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
