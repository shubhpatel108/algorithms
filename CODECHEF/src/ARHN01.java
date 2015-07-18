import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ARHN01 {
	public static void main(String arg[])throws Exception
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String toks[];
			int i;
			int num[] = new int[3];
			while(true)
			{
				toks = input.readLine().split(" ");
				for(i=0;i<3;i++)
				{
					num[i] = Integer.parseInt(toks[i]);
				}
				if(num[0]==0 && num[1]==0 && num[2]==0)
				{
					break;
				}
				else{
					if(num[2]==2*num[1]-num[0])
						System.out.println("AP " + (num[2] + num[1]-num[0]));
					else if( (num[0]!=0) && num[2]==(num[1]*num[1])/num[0])
					{
						System.out.println("GP " + (num[2] * num[1]/num[0]));
					}
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
