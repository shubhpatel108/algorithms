package summer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_551 {
	public static void main(String args[])throws Exception
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(input.readLine());
			int[] array = new int[2000];
			int[] orig = new int[n];
			String[] toks = input.readLine().split(" ");
			
			for(int i=0;i<n;i++)
			{
				int temp = Integer.parseInt(toks[i]);
				++array[temp];
				orig[i] = temp;
			}
			for(int i=1998;i>=0;i--)
				array[i] +=array[i+1];
			
			for(int i=0;i<n;i++)
			{
				if(orig[i]<2000)
					System.out.print(array[orig[i]+1] + 1 + " ");
				else
					System.out.print(1);
			}
		}catch(Exception e)
		{
			
		}
	}
}
