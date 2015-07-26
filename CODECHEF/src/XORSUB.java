//AC Time:0.80 Memory : 1400M
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class XORSUB {
	public static void main(String args[])throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(input.readLine());
			int i,j,n,k;
			boolean ans[] = new boolean[1025];
			int a[] = new int[1000];
			String line[];
			while(t-->0)
			{
				for(i=0;i<1025;i++)
					ans[i] = false;
				line = input.readLine().split(" ");
				n = Integer.parseInt(line[0]);
				k = Integer.parseInt(line[1]);
				line = input.readLine().split(" ");
				for(i=0;i<n;i++)
					a[i] = Integer.parseInt(line[i]);
				
				ans[k] = true;
				for(i=0;i<n;i++)
					for(j=0;j<1025;j++)
						if(ans[j])
						{
							ans[j^a[i]] = true;
						}
				j=1024;
				while(!ans[j])
					j--;
				
				System.out.println(j);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
