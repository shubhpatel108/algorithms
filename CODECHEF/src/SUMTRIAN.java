//AC Execution Time: 2.36sec
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SUMTRIAN {
	public static void main(String args[])throws Exception
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(input.readLine());
			int n,i,j,max;
			int mat[][];
			String toks[];
			while(t-->0)
			{
				n = Integer.parseInt(input.readLine());
				mat = new int[n][n];
				for(i=0;i<n;i++)
				{
					toks = input.readLine().split(" ");
					for(j=0;j<i+1;j++)
					{
						mat[i][j] = Integer.parseInt(toks[j]);
					}
				}
				for(i=1;i<n;i++)
				{
					mat[i][0] += mat[i-1][0];
					for(j=1;j<i+1;j++)
					{
						if(mat[i-1][j]>mat[i-1][j-1])
						{
							mat[i][j] += mat[i-1][j];
						}
						else
							mat[i][j] += mat[i-1][j-1];
					}
				}
				max=Integer.MIN_VALUE;
				for(j=0;j<n;j++)
				{
					if(max<mat[n-1][j])
						max = mat[n-1][j];
				}
				System.out.println(max);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
