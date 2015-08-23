package morganstanley15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinWeight {
	static int parents[];
	static int ranks[];
	static int weights[];
	
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		int q = Integer.parseInt(tokens[1]);

		weights = new int[n];
		parents = new int[n];
		ranks = new int[n];
		Arrays.fill(parents, -1);

		PriorityQueue<Integer> qu = new PriorityQueue<Integer>();
		tokens = input.readLine().split(" ");
		for(int i=0;i<n;i++) {
			int w = Integer.parseInt(tokens[i]);
			qu.add(w);
			weights[i] = w;
		}

		while(q-->0) {
			tokens = input.readLine().split(" ");
			int u = (Integer.parseInt(tokens[0]) - 1);
			int v = (Integer.parseInt(tokens[1]) - 1);

			int gu = find(u);
			int gv = find(v);

			if(gu != gv) {
				qu.remove(weights[gu]);
				qu.remove(weights[gv]);
				union(u,v);
				weights[find(u)] = weights[gu] + weights[gv];
				qu.add(weights[find(u)]);
			}
			System.out.println(qu.peek());
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
