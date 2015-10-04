
public class FloydWarshall {
	int[][] next;
	public int[][] allShortestPaths(GraphMatrix g, boolean pathNeeded) {
		int[][] dist = g.adjMatrix.clone();
		if(pathNeeded) {
			next = new int[g.V][g.V];
			for(int i=0;i<g.V;i++)
				for(int j=0;j<g.V;j++)
					if(dist[i][j]!=0 && dist[i][j]!=Integer.MAX_VALUE)
						next[i][j] = j;
					else
						next[i][j] = -1;
		}

		int maxValue = Integer.MAX_VALUE;

		for(int k=0;k<g.V;k++) {
			for(int i=0;i<g.V;i++) {
				for(int j=0;j<g.V;j++) {
					if(dist[i][k]!=maxValue && dist[k][j]!=maxValue
							&& dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						
						if(pathNeeded)
							next[i][j] = next[i][k];
					}
				}
			}
		}
		print(dist);
		return dist;
	}
	
	public void print(int[][] arr) {
		int n = arr.length;
		if(n<0)
			return;
		int m = arr[0].length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				System.out.print(String.format("%11d", arr[i][j]));
			System.out.println();
		}
	}
	
	public void shortestPath(int i, int j) {
		if(next[i][j]==-1)
			return;
		System.out.println(i);
		while(i!=j) {
			i = next[i][j];
			System.out.println(i);
		}
	}

}
