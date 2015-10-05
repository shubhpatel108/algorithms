/*
 * Adjacency matrix implementation of
 * Graph
 * 
*/
public class GraphMatrix {
	int V;
	int E;
	int[][] adjMatrix;
	boolean directed;
	
	public GraphMatrix(int V, boolean directed) {
		this.V = V;
		adjMatrix = new int[V][V];
		initialize();
		this.directed = directed;
	}
	
	public void initialize() {
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(i==j)
					adjMatrix[i][j] = 0;
				else
					adjMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	public void addEdge(int i, int j, int weight) {
		adjMatrix[i][j] = weight;
		if(!directed)
			adjMatrix[j][i] = weight;
		E++;
	}
	
	public void removeEdge(int i, int j) {
		adjMatrix[i][j] = Integer.MAX_VALUE;
		if(!directed)
			adjMatrix[j][i] = Integer.MAX_VALUE;
		E--;
	}

}
