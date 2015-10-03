
public class Controller {
	public static void main(String[] args)throws Exception {

		boolean directional = false;
		Graph g = new Graph(directional);
		int V = 4;

		g.initialize(V);
		Node a0 = g.nodes.get(0);
		Node a1 = g.nodes.get(1);
		Node a2 = g.nodes.get(2);
		Node a3 = g.nodes.get(3);
//		Node a4 = g.nodes.get(4);
//		Node a5 = new Node(5);
//		Node a6 = new Node(6);
//		Node a7 = new Node(7);
//		Node a8 = new Node(8);

		
		g.addEdge(a0, a1, 5);
		g.addEdge(a0, a2, 2);
		g.addEdge(a0, a3, 3);
		g.addEdge(a1, a2, 4);
		g.addEdge(a2, a3, 1);
		
//		g.addEdge(a0, a1, 0, direcational);
//		g.addEdge(a0, a2, 3, direcational);
//		g.addEdge(a0, a3, 3, direcational);
//		g.addEdge(a1, a2, 0, direcational);
//		g.addEdge(a2, a3, 0, direcational);
//		
//		g.addEdge(a3, a1, 9, direcational);

//		g.addEdge(a8, a7, 7, direcational);
//		g.addEdge(a7, a6, 1, direcational);
//		g.addEdge(a2, a8, 2, direcational);
//		g.addEdge(a8, a6, 6, direcational);
//		g.addEdge(a2, a3, 7, direcational);
//		g.addEdge(a3, a4, 9, direcational);
//		g.addEdge(a2, a5, 4, direcational);
//		g.addEdge(a6, a5, 2, direcational);
//		g.addEdge(a3, a5, 14, direcational);
//		g.addEdge(a4, a5, 10, direcational);
		
		g.showEdges();
		System.out.println("=============");
		
		MinSpanTree mst = new MinSpanTree();
		Graph mstGraph = mst.getMinSpanTree(g);
		mstGraph.showEdges();
		
//		for(Node n:g.nodes) {
//			System.out.println("==>" + g.getNodeIndex(n));
//			for(Node m:n.adjNodes)
//				System.out.println(g.getNodeIndex(m));
//		}
		
//		Traversals t = new Traversals();
//		t.IterativeBreadthFirst(g, g.getNode(0));
		
//		DetectCycle dc = new DetectCycle();
//		System.out.println(dc.hasCycle(g));
		
//		DijkstraShortestPath djs = new DijkstraShortestPath();
//		djs.shortestPathsToAll(g, g.nodes.get(0));
//		BellmanFordShortestPath bfsp = new BellmanFordShortestPath();
//		if(bfsp.shortestPathToAll(g, g.getNode(0))) {
//			for(Node n:g.nodes) {
//				System.out.println(n.distance);
//			}
//		} else {
//			System.out.println("Negative Cycle exist");
//		}
//		
//		TopologicalSort tp = new TopologicalSort();
//		for(Node n : tp.sort(g)) {
//			System.out.println(n.value);
//		}

//		GraphMatrix gm = new GraphMatrix(4, true);
//		gm.addEdge(0, 1, 5);
//		gm.addEdge(0, 3, 10);
//		gm.addEdge(1, 2, 3);
//		gm.addEdge(2, 3, 1);
//		
//		FloydWarshall fw = new FloydWarshall();
//		fw.allShortestPaths(gm, true);
//		fw.shortestPath(0, 3);
		
//		JohnsonAlgo  ja = new JohnsonAlgo();
//		ja.allShortestPaths(g);
		
//		PrimsMST mst = new PrimsMST();
//		Edge[] ans = mst.minSpanTree(g, g.nodes.get(0));
//		int count = 0;
//
//		for(Edge e : ans) {
//			count += e.weight;
//			System.out.println(e.src.value +  " to " + e.dest.value);
//		}
//		System.out.println(count);
	}
}
