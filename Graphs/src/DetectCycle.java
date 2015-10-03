import java.util.Arrays;


public class DetectCycle {
	boolean[] visited;
	boolean[] recStack;
	public boolean hasCycle(Graph g) {
		visited = new boolean[g.V];
		recStack = new boolean[g.V];
		
		for(Node n : g.nodes)
			if(hasCycleUtil(g, n) == true)
				return true;
		
		return false;
	}
	
	public boolean hasCycleUtil(Graph g, Node n) {
		int index = g.getNodeIndex(n);

		if(!visited[index]) {
			visited[index] = true;
			recStack[index] = true;
			
			for(Node m: n.adjNodes()) {
				int i = g.getNodeIndex(m);
				if(!visited[i] && hasCycleUtil(g, m)) {
					return true;
				} else if(recStack[i]) {
					return true;
				}
			}
		}
		recStack[index] = false;
		return false;
	}
}
