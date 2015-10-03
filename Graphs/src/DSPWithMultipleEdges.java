// https://www.hackerrank.com/challenges/dijkstrashortreach
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DSPWithMultipleEdges {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);
			
			Graph g = new Graph(false);
			
			for(int i=0;i<n;i++)
				g.addNode(i);
			
			for(int i=0;i<m;i++) {
				tokens = input.readLine().split(" ");
				g.addEdge(Integer.parseInt(tokens[0])-1, Integer.parseInt(tokens[1])-1, Integer.parseInt(tokens[2]));
			}
//			g.showEdges();
			int src = Integer.parseInt(input.readLine()) - 1;
			DijkstraShortestPath d = new DijkstraShortestPath();
			d.shortestPathsToAll(g, g.getNode(src));
			
			for(int i=0;i<g.V;i++) {
				if(src==i)
					continue;
				if(g.nodes.get(i).distance!=Integer.MAX_VALUE)
					System.out.print(g.nodes.get(i).distance + " ");
				else
					System.out.print(-1);
			}
			System.out.println();
		}
	}

}