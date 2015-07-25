import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class TopFrom2Array {
	public static void main(String args[])throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String line[] = input.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int a[] = new int[n];
			int b[] = new int[n];
			int i, a_lim, b_lim, temp, j,k;
			int count=0, sum=0;
			a_lim = Integer.parseInt(line[1]);
			b_lim = Integer.parseInt(line[2]);
			count = a_lim;
			line = input.readLine().split(" ");
			for(i=0;i<n;i++)
				a[i] = Integer.parseInt(line[i]);
			line = input.readLine().split(" ");
			for(i=0;i<n;i++)
				b[i] = Integer.parseInt(line[i]);
			Arrays.sort(a);
			Arrays.sort(b);
			for(i=0;i<n/2;i++)
			{
				temp = b[i];
				b[i] = b[n-i-1];
				b[n-i-1] = temp;
			}
			for(i=0;i<n/2;i++)
			{
				temp = a[i];
				a[i] = a[n-i-1];
				a[n-i-1] = temp;
			}
			j=0;k=0;
			int flag = 0;
			for(i=0;i<n;i++)
			{
				if(j==a_lim)
				{
					flag = 1;
					break;
				}
				if(k==b_lim)
				{
					flag = 2;
					break;
				}
				if(j<a_lim && a[j]>=b[k])
				{
					sum += a[j];
					j++;
				}
				else if(k<b_lim && b[k]>=a[j])
				{
					sum += b[k];
					k++;
				}
			}
			
			if(flag==1)
			{
				while(i<n && k<b_lim)
				{
					sum += b[k];
					i++;k++;
				}	
			}
			else if(flag==2)
				while(i<n && j<a_lim)
				{
					sum+= a[j];
					i++;j++;
				}
			System.out.println(sum);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
