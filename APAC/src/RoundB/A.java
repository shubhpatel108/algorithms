package RoundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	static Node[] graph;
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());

		for(int y=1;y<=t;y++) {
			String[] tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);
			int k = Integer.parseInt(tokens[2]);
			
			graph = new Node[n];

			for(int i=0;i<n;i++) {
				Node temp = new Node(i, n);
				graph[i] = temp;
			}

			for(int i=0;i<m;i++) {
				tokens = input.readLine().split(" ");
				int u = Integer.parseInt(tokens[0])-1;
				int v = Integer.parseInt(tokens[1])-1;
				graph[u].addAdjNode(v);
				graph[v].addAdjNode(u);
				
				tokens = input.readLine().split(" ");
				int arr[] = new int[24];
				for(int j=0;j<24;j++) {
					arr[j] = Integer.parseInt(tokens[j]);
				}
				graph[u].setTimes(arr, v);
			}
			
			System.out.println("Case #"+y+":");
			for(int i=0;i<k;i++) {
				tokens = input.readLine().split(" ");
				int d = Integer.parseInt(tokens[0])-1;
				int s = Integer.parseInt(tokens[1]);
				
				System.out.print(pathTime(0, d, s, 0) + " ");
			}
//			graph[2].printAdj();
			System.out.println();
		}
	}
	
	public static int pathTime(int s, int  d, int startTime, int total) {
		if(s==d)
			return total;
		
		int min = Integer.MAX_VALUE;
		Node start = graph[s];
		start.visited = true;
		int degree = start.adjNodes.size();

		if(degree==0)
			return -1;
		
		for(int i=0;i<degree;i++) {
			int v = start.adjNodes.get(i);
			
			if(!graph[v].visited) {
				int t = start.times[v][startTime%24];
				
				t = pathTime(v, d, startTime+t, total+t);

				if(t!=-1 && t<min){
					min = t;
				}
			}
		}
		start.visited = false;
		if(min == Integer.MAX_VALUE)
			min = -1;
		return min;
	}

}