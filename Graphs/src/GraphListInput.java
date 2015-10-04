
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GraphListInput {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		int t = 1;
		
		while(t-->0) {
			String[] tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);
			
			Graph g = new Graph(false);

			for(int i=0;i<m;i++) {
				tokens = input.readLine().split(" ");
				g.addEdge(Integer.parseInt(tokens[0])-1, Integer.parseInt(tokens[1])-1, Integer.parseInt(tokens[2]));
			}
//			g.showEdges();
			int source = Integer.parseInt(input.readLine()) - 1;
			
//			PrimsMST mst = new PrimsMST();
//			Edge[] edges = mst.minSpanTree(g, source);
//			
//			kruskalmstrsub kmst = new kruskalmstrsub();
//			System.out.println(SimpleEdge.sumOfWeights(kmst.minTree(g, n)));
			
			MinSpanTree mst = new MinSpanTree();
			Graph mstGraph = mst.getMinSpanTree(g);
			System.out.println(Edge.sumOfWeights(mstGraph.edges));
		}
	}

}