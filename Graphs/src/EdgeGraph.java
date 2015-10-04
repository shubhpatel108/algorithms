import java.util.ArrayList;
import java.util.List;

/* 
 * Graph with only custom edges (SimpleEdge.java)
 * used in algos like Kruskal, etc. with vertex is irrelevant
 * 
*/
public class EdgeGraph {
	List<SimpleEdge> edges = new ArrayList<SimpleEdge>();

	public void addEdge(int uNode, int vNode, int weight) {
		SimpleEdge edge = new SimpleEdge(uNode, vNode, weight);
		edges.add(edge);
	}

}
