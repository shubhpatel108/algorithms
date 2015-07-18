import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ARHN07 {
	public static void main(String args[])
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String toks[];
			int t = Integer.parseInt(input.readLine());
			String l1,l2;
			int i,count;
			while(t-->0)
			{
				l1 = input.readLine();
				l2 = input.readLine();
				if(l1.length()!=l2.length())
				{
					System.out.println(-1);
				}
				else
				{
					count=0;
					for(i=0;i<l1.length();i++)
					{
						if(l1.charAt(i)!=l2.charAt(i))
						{
							count++;
						}
					}
					System.out.println(count);
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
