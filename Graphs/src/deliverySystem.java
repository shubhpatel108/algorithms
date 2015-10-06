
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class deliverySystem {
	public static void main(String args[])throws Exception {
		
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);
			int k = Integer.parseInt(tokens[2]);

			tokens = input.readLine().split(" ");
			boolean[] cities = new boolean[n];
			
			for(int i=0;i<k;i++)
				cities[Integer.parseInt(tokens[i]) - 1] = true;
			
			Graph g = new Graph(false);
			g.initialize(n);

			for(int i=0;i<m;i++) {
				tokens = input.readLine().split(" ");
				g.addEdge(Integer.parseInt(tokens[0])-1, Integer.parseInt(tokens[1])-1, 0);
			}
			TopologicalSort tp = new TopologicalSort();
			List<Node> tps = tp.sort(g);
			
			if(tps == null)
				System.out.print(-1);
			else {
				for(Node node : tps) {
					if(cities[node.index])
						System.out.print(node.index + 1 + " ");
				}
			}
			System.out.println();
		}
	}
}
