import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ARHN09 {
	public static void main(String args[])
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String toks[];
			toks = input.readLine().split(" ");
			int n = Integer.parseInt(toks[0]);
			int q = Integer.parseInt(toks[1]);
			int num[] = new int[n];
			int start, end;
			toks = input.readLine().split(" ");
			num[0] = Integer.parseInt(toks[0]);
			for(int i=1;i<n;i++)
			{
				num[i] = num[i-1] + Integer.parseInt(toks[i]);
			}
			while(q-->0)
			{
				toks = input.readLine().split(" ");
				start = Integer.parseInt(toks[1])-1;
				end = Integer.parseInt(toks[2])-1;
				if(start==0)
					System.out.println(num[end]);
				else
					System.out.println(num[end] - num[start-1]);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
