//WA
package C321_580;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
	static int m;
	static Node[] arr;
	static int ans = 0;
	
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		m = Integer.parseInt(tokens[1]);
		
		tokens = input.readLine().split(" ");
		arr = new Node[n];

		for(int i=0;i<n;i++) {
			Node node = new Node(i, tokens[i].equals("1"));
			arr[i] = node;
		}
		
		for(int i=1;i<n;i++) {
			tokens = input.readLine().split(" ");
			int u = Integer.parseInt(tokens[0]) - 1;
			int v = Integer.parseInt(tokens[1]) - 1;
			
			arr[u].addNode(arr[v]);
			arr[v].addNode(arr[u]);
		}
		solve(arr[0], 0, null);
		System.out.println(ans);
	}
	
	public static void solve(Node node, int k, Node parent) {
		
		if(node.visited)
			return;

		node.visited = true;

		int newk = k;
		if(node.hasCats)
			newk++;

		if(parent!= null && node.children.size() == 1) {
			if(newk <= m)
				ans++;
			return;
		}

		if(!node.hasCats)
			newk = 0;
		
		for(Node temp : node.children) {
			solve(temp, newk, node);
		}
	}
}
