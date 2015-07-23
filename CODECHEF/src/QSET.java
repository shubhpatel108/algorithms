//WA reason: considers only string ending at index - type scenarios
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QSET {
	static int d[];
	static int data[][];
	public static void main(String args[])throws Exception
	{
		
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String toks[];
			toks = input.readLine().split(" ");
			int n = Integer.parseInt(toks[0]);
			int queries = Integer.parseInt(toks[1]);
			d = new int[n];
			data = new int [3][n];
			int index, st,en,temp,temp2;
			int i, sum = 0;
			String line = input.readLine();
			for(i=0;i<n;i++)
			{
				d[i] = Integer.parseInt(String.valueOf(line.charAt(i))) % 3;
			}
			data[d[0]][0] += 1;
			update_data(0);
			while(queries-->0)
			{
				toks = input.readLine().split(" ");
				
				if(Integer.parseInt(toks[0])==1)
				{
					System.out.println(Arrays.toString(d));
					System.out.println(Arrays.toString(data[0]));
					System.out.println(Arrays.toString(data[1]));
					System.out.println(Arrays.toString(data[2]));
					System.out.println("-------------");
					index = Integer.parseInt(toks[1]) - 1;
					temp = Integer.parseInt(toks[2])%3;
					
					d[index] = temp;
					for(int j=0;j<3;j++)
					{
						temp2 = (((j+d[index])%3) + d[index])%3;
						data[j][i] = data[temp2][i-1];
					}
					data[temp][index]++;
					
					update_data(index);
					
					System.out.println(Arrays.toString(d));
					System.out.println(Arrays.toString(data[0]));
					System.out.println(Arrays.toString(data[1]));
					System.out.println(Arrays.toString(data[2]));
					System.out.println("-------------");
					
				}
				else if(Integer.parseInt(toks[0])==2)
				{
					st = Integer.parseInt(toks[1]) - 1;
					en = Integer.parseInt(toks[2]) - 1;
					sum = 0;
					for(i=st;i<=en;i++)
					{
						sum += data[0][i];
					}
					System.out.println(sum);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	static void update_data(int start)
	{	
		try
		{
			int cycle;
			int i,j,temp;
			for(i=start+1;i<d.length;i++)
			{
				cycle = d[i];
				for(j=0;j<3;j++)
				{
					temp = (((j+cycle)%3) + cycle)%3;
					data[j][i] = data[temp][i-1];
				}
				data[d[i]][i]++;
			}
			
//			System.out.println(Arrays.toString(data[0]));
//			System.out.println(Arrays.toString(data[1]));
//			System.out.println(Arrays.toString(data[2]));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
