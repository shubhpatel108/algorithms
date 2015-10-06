import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.hackerrank.com/challenges/bfsshortreach

public class bfsshortreach {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			Graph g = new Graph(false);
			
			String[] ts = input.readLine().split(" ");
			int n = Integer.parseInt(ts[0]);
			int m = Integer.parseInt(ts[1]);
			
			for(int i=0;i<n;i++) {
				g.addNode(i);
				g.nodes.get(i).value = -1;
			}

			for(int i=0;i<m;i++) {
				ts = input.readLine().split(" ");
				int a = Integer.parseInt(ts[0]) - 1;
				int b = Integer.parseInt(ts[1]) - 1;

				g.addEdge(a, b, 6);
			}
			
			int s = Integer.parseInt(input.readLine());
			
			LinkedList<Node> q = new LinkedList<Node>();
			Node start = g.nodes.get(s - 1);
			start.value = 0;
			q.add(start);
			while(!q.isEmpty()) {
				Node node = q.poll();
				node.visited = true;
				for(Node mode : node.adjNodes()) {
					if(!mode.visited) {
						mode.value = node.value + 6;
						q.add(mode);
					}
				}
			}
			for(Node node : g.nodes) {
				if(node != start)
					System.out.print(node.value + " ");
			}
		}
	}

}
