//https://www.hackerrank.com/challenges/primsmstsub
public class PrimsMST {
	public Edge[] minSpanTree(Graph g, int src) {
		Node source = g.getNode(src);
		Edge[] mstEdges = new Edge[g.V-1];
		
		source.distance = 0;
		Heap heap = new Heap(new Node.NodeDistanceCompare());
		
		for(Node node : g.nodes) {
			heap.push(node);
		}
		
		int index = 0;
		while(heap.heap.size() > 0) {
			Node node = heap.pop();
			node.visited = true;
			
			if(node.minTreeEdge!=null) {
				mstEdges[index] = node.minTreeEdge;
				index++;
			}
			for(Edge e : node.adjEdges) {
				relax(heap, e);
			}
		}
		return mstEdges;
	}
	
	public void relax(Heap heap, Edge e) {
		if(e.dest.visited)
			return;

		if(e.dest.distance > (e.weight)) {
			e.dest.distance = e.weight;
			e.dest.minTreeEdge = e;
			heap.pushUp(e.dest.index);
		}
	}
}
