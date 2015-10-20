//AC
package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KingdomOfMonkeys {
	static int[] parents;
	static int[] ranks;

	public static void main(String[] args)throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		
		while(t-->0) {
			String[] tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);
			
			parents = new int[n];
			Arrays.fill(parents, -1);
			ranks = new int[n];
			
			for(int i=0;i<m;i++) {
				tokens = input.readLine().split(" ");
				union(Integer.parseInt(tokens[0])-1, Integer.parseInt(tokens[1])-1);
			}
			
			long[] weights = new long[n];
			
			tokens = input.readLine().split(" ");
			for(int i=0;i<n;i++) {
				weights[find(i)] += Long.parseLong(tokens[i]);
			}
			
			long max = Long.MIN_VALUE;
			for(int i=0;i<n;i++) {
				if(max < weights[i])
					max = weights[i];
			}
			
			System.out.println(max);
		}
	}
	
	public static boolean union(int i, int j) {
		int x = find(i);
		int y = find(j);
		
		if(x == y)
			return false;

		if(ranks[x] > ranks[y]) {
			parents[y] = x;
		} else if(ranks[x] < ranks[y]){
			parents[x] = y;
		} else {
			parents[y] = x;
			ranks[x]++;
		}
		return true;
	}
	
	public static int find(int i) {
		if(parents[i] == -1)
			return i;
		return find(parents[i]);
	}
}
