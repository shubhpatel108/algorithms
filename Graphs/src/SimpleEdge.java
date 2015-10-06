import java.util.Comparator;

/*
 * Used in undirected Graph
 * especially. EdgeGraph.java
*/
public class SimpleEdge {
	int uNode;
	int vNode;
	int weight;
	
	public SimpleEdge(int uNode, int vNode, int weight) {
		this.uNode = uNode;
		this.vNode = vNode;
		this.weight = weight;
	}
	
	public static long sumOfWeights(SimpleEdge[] edges) {
		long sum = 0;
		for(SimpleEdge e : edges)
			sum += e.weight;

		return sum;
	}
	
	public static class EdgeCustomCompare1 implements Comparator<SimpleEdge>{
		
		@Override
		public int compare(SimpleEdge e1, SimpleEdge e2) {
			if(e1.weight < e2.weight)
				return -1;
			else if(e1.weight > e2.weight)
				return 1;
			else {
				int value = ( (e1.weight + e1.uNode + e1.vNode) < 
						(e2.weight + e2.uNode + e2.vNode)) ? -1 : 1;
				return value;
			}
		}
	}
}
