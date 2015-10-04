// https://www.hackerrank.com/challenges/even-tree
// AC

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EvenTree {
	static int ans = 0;
	static Graph g = new Graph(true);
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] ts = input.readLine().split(" ");
		int n = Integer.parseInt(ts[0]);
		int m = Integer.parseInt(ts[1]);
		
		if(n%2==1) {
			System.out.println(0);
			return;
		}

		
		for(int i=0;i<n;i++) {
			g.addNode(i);
		}
		
		for(int i=0;i<m;i++) {
			ts = input.readLine().split(" ");
			int a = Integer.parseInt(ts[0]);
			int b = Integer.parseInt(ts[1]);
			
			int parent = Math.min(a, b) - 1;
			int child = Math.max(a, b) - 1;

			g.addEdge(g.getNode(parent), g.getNode(child), 4);
		}
		height(g.getNode(0));
		System.out.println(ans);
	}
	
	public static int height(Node node) {
		if(node == null)
			return 0;
		int neighbors = node.adjNodes().size();
		if(neighbors==0)
			return 1;
		int sum = 0;
		for(Node adjNode: node.adjNodes()) {
			int h = height(adjNode);
			if(h%2==0 && h!=0){
				ans++;
				System.out.println(node.value+" "+adjNode.value);
			}
			else
				sum += h;
		}
		return sum+1;
	}
}
