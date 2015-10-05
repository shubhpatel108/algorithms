import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.hackerearth.com/code-monk-graph-theory-ii/algorithm/mittal-wants-to-go-to-play/
*/
public class MittalPlay {
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
			
			DijkstraShortestPath djs = new DijkstraShortestPath();
			djs.shortestPathsToAll(g, g.nodes.get(0));
			
			int q = Integer.parseInt(input.readLine());
			while(q-->0) {
				tokens = input.readLine().split(" ");
				int index = Integer.parseInt(tokens[0]) - 1;
				int k = Integer.parseInt(tokens[1]);
				System.out.println(Math.max(0, k - 2*g.getNode(index).distance));
			}
		}
	}
}
