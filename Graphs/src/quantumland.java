import java.io.BufferedReader;
import java.io.InputStreamReader;


public class quantumland {
	static double ans = 1;
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		int t = 1;
		
		while(t-->0) {
			String[] tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			
			Graph g = new Graph(true);
			g.initialize(n);

			for(int i=0;i<n;i++) {
				tokens = input.readLine().split(" ");
				if(Integer.parseInt(tokens[1])!=0)
					g.addEdge(i, Integer.parseInt(tokens[0])-1, Integer.parseInt(tokens[1]));
			}
			
			double prob = 0;
			int cycleNum = 0;
			for(Node node : g.nodes) {
				if(!node.visited) {
					prob += prob(node, 0, 1, cycleNum++);
				}
			}
			System.out.println( String.format( "%.2f", prob ) );
		}
	}
	
	
	public static double prob(Node node, int cycle, double value, int cycleNum) {
		node.visited = true;
		node.value = cycle;
		node.distance = cycleNum;

		Node next = node.adjEdges.get(0).dest;
		double mul = value*node.adjEdges.get(0).weight/100;
		
		if(next.visited) {
			if(next.distance==cycleNum) {
				if(cycle + 1 - next.value >=2)
					return mul;
				else
					return 0;
			} else {
				return 0;
			}
		}

		return prob(next, cycle+1, mul, cycleNum);
	}
}
