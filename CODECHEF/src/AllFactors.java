//changed to gcd of an array;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class AllFactors {
	static int num[];
	static Map hm;
	static Iterator it;
	public static void main(String args[])throws Exception
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(input.readLine());
			int i,j,n,q,start,end;
			String toks[];
			
			int maxd, ans;
			while(t-->0)
			{
				hm = new HashMap();
				toks = input.readLine().split(" ");
				n = Integer.parseInt(toks[0]);
				q = Integer.parseInt(toks[1]);
				num = new int[n];
				maxd = 0;
				ans = 1;
				toks = input.readLine().split(" ");
				
				num[0] = Integer.parseInt(toks[0]);
				for(i=1;i<=(int)num[0]/2;i++)
				{
					if(num[0]%i == 0)
					{
						hm.put(i,1);
					}
				}
				hm.put(num[0], 1);
				for(i=1;i<n;i++)
				{
					it = hm.entrySet().iterator();
					num[i] = Integer.parseInt(toks[i]);
					while(it.hasNext())
					{
						Map.Entry pairs = (Map.Entry)it.next();
						if((num[i] % (int)pairs.getKey()) == 0 )
						{
							hm.put(pairs.getKey(), (int)hm.get((pairs.getKey())) +1);
						}
					}
				}
				System.out.println(gcd(hm, 0,n-1));
				
				while(q-->0)
				{
					toks = input.readLine().split(" ");
					System.out.println(remove_from_hm(Integer.parseInt(toks[0])-1, Integer.parseInt(toks[1])-1));
				}
				
				hm.clear();
				num = null;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	static int gcd(Map hm3, int start, int end)
	{
		int length = end-start+1;
		int ans=1;
		it = hm3.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pairs = (Map.Entry)it.next();
			if(length == (int)pairs.getValue())
			{
				ans = (int)pairs.getKey();
			}
		}

		return ans;
	}
	
	static int remove_from_hm(int start, int end)
	{
		int i;
		Map hm2 = new HashMap();
		Map hm3 = new HashMap();
		
		for(i=1;i<=(int)num[start]/2;i++)
		{
			if(num[0]%i == 0)
			{
				hm2.put(i,1);
			}
		}
		hm2.put(num[0], 1);
		

		System.out.println("++++++++");
		it = hm2.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey()+"-"+pairs.getValue());
		}
		System.out.println("++++++++");
		
		
		for(i=start+1;i<=end;i++)
		{
			System.out.println("adddas");
			it = hm2.entrySet().iterator();
			while(it.hasNext())
			{
				Map.Entry pairs = (Map.Entry)it.next();
				if((num[i] % (int)pairs.getKey()) == 0 )
				{
					hm2.put(pairs.getKey(), (int)hm2.get((pairs.getKey())) +1);
				}
			}
		}
		
		System.out.println("++++++++");
		it = hm2.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey()+"-"+pairs.getValue());
		}
		System.out.println("++++++++");
		
		
		
		it = hm.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pairs = (Map.Entry)it.next();
			if(hm2.containsKey(pairs.getKey()))
			{
				System.out.println("this in hm2"+pairs.getKey());
				hm3.put(pairs.getKey(), (int)hm.get(pairs.getKey()) - (int)hm2.get(pairs.getKey()) );
			}
			else
			{
				System.out.println("this not hm2"+pairs.getKey());
				hm3.put(pairs.getKey(), (int)hm.get(pairs.getKey()));
			}
		}
		System.out.println("++++++++");
		it = hm3.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey()+"-"+pairs.getValue());
		}
		System.out.println("++++++++");
		
		return gcd(hm3, 0, hm.size());
	}
}
