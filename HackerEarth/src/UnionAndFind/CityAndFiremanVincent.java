package UnionAndFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CityAndFiremanVincent {
	static int[] total;
	static int[] mins;
	static int[] parents;
	static int[] ranks;
	
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		parents = new int[n];
		Arrays.fill(parents, -1);
		ranks = new int[n];		
		mins = new int[n];
		total = new int[n];
		Arrays.fill(total, 1);

		String[] tokens = input.readLine().split(" ");
		for(int i=0;i<n;i++)
			mins[i] = Integer.parseInt(tokens[i]);
		
		int k = Integer.parseInt(input.readLine());
		while(k-->0) {
			tokens = input.readLine().split(" ");
			union(Integer.parseInt(tokens[0])-1, Integer.parseInt(tokens[1])-1);
		}

		long ans = 1;
		for(int i=0;i<n;i++) {
			if(parents[i]<0) {
				ans *= total[i];
			}
		}
		System.out.println(ans%(1000000007));
	}
	
	
	public static boolean union(int i, int j) {
		int x = find(i);
		int y = find(j);
		
		if(x == y)
			return false;

		if(ranks[x] > ranks[y]) {
			parents[y] = x;
			
			if(mins[x] == mins[y])
				total[x] += total[y];
			else if(mins[x]>mins[y]) {
				total[x] = total[y];
				mins[x] = mins[y];
			}
		} else if(ranks[x] < ranks[y]){
			parents[x] = y;
			

			if(mins[x] == mins[y])
				total[y] += total[x];
			else if(mins[y]>mins[x]) {
				total[y] = total[x];
				mins[y] = mins[x];
			}
		} else {
			parents[y] = x;
			ranks[x]++;
			
			if(mins[x] == mins[y])
				total[x] += total[y];
			else if(mins[x]>mins[y]) {
				total[x] = total[y];
			}
		}
		return true;
	}
	
	public static int find(int i) {
		if(parents[i] == -1)
			return i;
		return find(parents[i]);
	}
}
