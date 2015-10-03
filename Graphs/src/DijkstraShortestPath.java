import java.util.Arrays;


public class DijkstraShortestPath {
	public void shortestPathsToAll(Graph g, Node source) {
		for(Node n:g.nodes) {
			n.distance = Integer.MAX_VALUE;
			n.visited = false;
		}

		source.distance = 0;

		Heap heap = new Heap(new Node.NodeDistanceCompare());

		for(int i=0;i<g.V;i++) {
			heap.push(g.nodes.get(i));
		}

		for(int i=0;i<g.V;i++) {
			Node n = heap.pop();
			n.visited = true;
			
			for(Edge e: n.adjEdges) {
//				System.out.println("Relaxing dest "+e.dest.value + " "+e.dest.distance);
				relax(heap, e);
//				g.nodes.get(g.nodes.indexOf(e.dest)).distance = e.dest.distance;
//				System.out.println("Relaxed dest "+e.dest.value + " "+e.dest.distance);
//				customRelax(heap, e, n);
			}
		}
		
//		for(int i=0;i<g.V;i++) {
//			System.out.print(g.nodes.get(i).distance + " ");
//		}
//		System.out.println();
	}
	
	public void relax(Heap heap, Edge e) {
		if(e.dest.visited)
			return;

		if(e.dest.distance > (e.src.distance + e.weight)) {
			e.dest.distance = e.src.distance + e.weight;
			heap.pushUp(e.dest.index);
		}
	}
	
	public void customRelax(Heap heap, Edge edge, Node n) {
		if(!edge.dest.visited) {
			int heapInd = edge.dest.index;
			Node heapNode = heap.getNode(heapInd);
			if(heapNode.distance > (n.distance + edge.weight)) {
				heapNode.distance = n.distance + edge.weight;
				heap.pushUp(heapInd);
			}
		}
	}
}
