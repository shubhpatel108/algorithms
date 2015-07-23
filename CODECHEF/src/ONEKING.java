//AC but TLE for large inputs
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class ONEKING {
	static ArrayList<Interval> list = new ArrayList<Interval>();
	public static void main(String args[])throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(input.readLine());
			int n,i;
			String line[];
			Interval a,b;
			while(t-->0)
			{
				n = Integer.parseInt(input.readLine());
				for(i=0;i<n;i++)
				{
					line = input.readLine().split(" ");
					insert(new Interval(Integer.parseInt(line[0]), Integer.parseInt(line[1])));	
				}
				for(i=1;i<list.size();)
				{
					a = list.get(i-1);
					b = list.get(i);
					if(b.start<=a.end)
					{
						a.start = Math.max(a.start, b.start);
						a.end = Math.min(a.end, b.end);
						list.remove(i);
					}
					else
					{
						i++;
					}
				}
				System.out.println(list.size());
				list.clear();
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void insert(Interval inter)
	{
		try{
			if(list.isEmpty() || list.get(list.size()-1).start<=inter.start)
			{
				list.add(inter);
			}
			else if(list.get(0).start>=inter.start)
			{
				list.add(0, inter);
			}
			else
			{
				int middle=0;
				int s = 0;
				int p = list.size() - 1;
				int number = inter.start;
				while(s<p)
				{
					middle = (s+p)/2;
					if(list.get(middle).start<=number)
					{
						if(list.get(middle+1).start>=number)
						{
							list.add(middle+1, inter);
							return;
						}
						else
						{
							s = middle + 1;
							continue;
						}
					}
					else
					{
						if(list.get(middle-1).start<=number)
						{
							list.add(middle, inter);
							return;
						}
						else
						{
							p = middle - 1;
							continue;
						}
					}
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
