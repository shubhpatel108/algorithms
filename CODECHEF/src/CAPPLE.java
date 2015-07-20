//AC ET: 0.36 Mem:1399M
//finding number of distinct element using hash

import java.io.*;
import java.util.HashMap;
public class CAPPLE {
	public static void main(String args[]) throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(input.readLine());
			int m,i, uniq;
			HashMap hm = new HashMap();
			String tokens[];
			while(n-->0)
			{
				uniq=0;
				m = Integer.parseInt(input.readLine());
				tokens = input.readLine().split(" ");
				for(i=0;i<tokens.length;i++)
				{
					if(!hm.containsKey(tokens[i]))
					{
						hm.put(tokens[i], true);
						uniq++;
					}
				}
				hm.clear();
				System.out.println(uniq);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
