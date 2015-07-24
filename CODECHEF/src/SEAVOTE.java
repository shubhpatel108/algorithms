//AC
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SEAVOTE {
	public static void main(String args[])throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(input.readLine());
			String line[];
			int n[]= new int[10000];
			int m,i,sum=0,zeros=0,hunds=0;
			boolean flag=false;
			while(t-->0)
			{
				m = Integer.parseInt(input.readLine());
				line = input.readLine().split(" ");
				sum = 0;
				zeros = 0;
				hunds = 0;
				flag = false;
				for(i=0;i<m;i++)
				{
					n[i] = Integer.parseInt(line[i]);
					sum += n[i];
					if(n[i]==0)
						zeros++;
					else if(n[i]==100)
						hunds++;
					if(n[i]>100)
					{
						System.out.println("NO");
						flag = true;
						break;
					}
				}
				if(!flag)
				{
					if(sum==100)
						System.out.println("YES");
					else if(sum<100)
						System.out.println("NO");
					else
					{
						if((sum-100)/(m-zeros) < 1)
							System.out.println("YES");
						else
							System.out.println("NO");
					}
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
