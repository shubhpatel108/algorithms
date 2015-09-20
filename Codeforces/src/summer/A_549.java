//AC
package summer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_549 {
	static int[] ivals = { 0,-1,-1,-1,-1, 0, 0, 1, 1, 1, 1, 0};
	static int[] jvals = {-1,-1, 0, 0, 1, 1, 1, 1, 0, 0, -1, -1};
	public static void main(String args[]) throws Exception
	{
		try {
			
		//a-0, c-1, e-2
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens;
		String line;
		
		
		
		tokens = input.readLine().split(" ");
		int m = Integer.parseInt(tokens[0]);
		int n = Integer.parseInt(tokens[1]);
		char[][] rect = new char[m][n];
		int ans = 0;
		
		for(int i=0;i<m;i++)
		{
			line = input.readLine();
			for(int j=0;j<n;j++)
				rect[i][j] = line.charAt(j);
		}
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(rect[i][j] == 'f')
				{
					if(i>0 && j>0)
						ans = util(rect, i, j, 0, 3, ans);
					if(i>0 && j<n-1)
						ans = util(rect, i, j, 3, 6, ans);
					if(i<m-1 && j<n-1)
						ans = util(rect, i, j, 6, 9, ans);
					if(i<m-1 && j>0)
						ans = util(rect, i, j, 9, 12, ans);
				}
			}
		}
		System.out.println(ans);
		
		}catch(Exception e)
		{}
	}
	
	public static int util(char[][] rect, int i, int j, int from , int to, int ans)
	{
		int[] array = new int[3];
		int k=0;
		
		for(k=from;k<to;k++)
		{
			char c = rect[i + ivals[k]][j + jvals[k]];
			if(c== 'a')
				array[0]++;
			else if(c=='c')
				array[1]++;
			else if(c=='e')
				array[2]++;
		}
		boolean flag = true;
		for(int count=0;count<3;count++)
		{
			if(array[count]==0)
				flag=false;
			array[count] = 0;
		}
		if(flag)
			ans++;
		
		return ans;
	}
}
