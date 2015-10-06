import java.util.LinkedList;

public class Traversals {
	public void IterativeBreadthFirst(Graph g, Node root) {
		if(root == null)
			return;
		LinkedList<Node> q = new LinkedList<Node>();
		boolean[] visited = new boolean[g.V];
		
		q.push(root);
		while(!q.isEmpty()) {
			Node node = q.removeLast();
			int index = g.getNodeIndex(node);
			if(!visited[index]) {
				System.out.println(node.value);
				visited[index] = true;
				for(Node n:node.adjNodes()) {
					q.push(n);
				}
			}
		}
	}
	
}
