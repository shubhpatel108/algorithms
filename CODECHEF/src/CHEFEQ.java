//AC
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CHEFEQ {
	public static void main(String args[])throws Exception
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(input.readLine());
			String toks[];
			HashMap hm = new HashMap();
			while(t-->0)
			{
				int n = Integer.parseInt(input.readLine());
				toks = input.readLine().split(" ");
				for(int i =0;i<n;i++)
				{
					if(hm.containsKey(toks[i]))
						hm.put(toks[i], (int)hm.get(toks[i]) + 1);
					else
						hm.put(toks[i], 1);
				}
				int max = Integer.MIN_VALUE;
				boolean flag = false;
				Iterator it = hm.entrySet().iterator();
				while(it.hasNext())
				{
					Map.Entry pairs = (Map.Entry)it.next();
					if((int)pairs.getValue() > max)
					{
						max = (int)pairs.getValue();
					}
				}
				System.out.println(n-max);
				hm.clear();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
