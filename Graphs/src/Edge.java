import java.util.ArrayList;
import java.util.Comparator;


public class Edge {
	Node src, dest;
	int weight;
	boolean directional;

	public Edge(Node src, Node dest, int weight, boolean directional) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
		this.directional = directional;
	}
	
	public static long sumOfWeights(Edge[] edges) {
		long sum = 0;
		for(Edge e : edges)
			sum += e.weight;
		
		return sum;
	}
	
	public static long sumOfWeights(ArrayList<Edge> edges) {
		long sum = 0;
		for(Edge e : edges)
			sum += e.weight;
		
		return sum;
	}
	
	public static class EdgeCompare implements Comparator<Edge>{
		
		@Override
		public int compare(Edge e1, Edge e2) {
			if(e1.weight < e2.weight)
				return -1;
			else if(e1.weight > e2.weight)
				return 1;
			else
				return 0;
		}
	}

}
