package hack101sep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CitiesLight {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			tokens = input.readLine().split(" ");
			Node[] graph = new Node[n];
			
			for(int i=0;i<n;i++) {
				boolean b = Integer.parseInt(tokens[i])==0? false:true;
				graph[i] = new Node(0, b, i);
			}
			
			for(int i=1;i<n;i++) {
				tokens = input.readLine().split(" ");
				int u = Integer.parseInt(tokens[0])-1;
				int v = Integer.parseInt(tokens[1])-1;
				graph[u].addAdj(graph[v]);
				graph[v].addAdj(graph[u]);
			}
			
			Heap heap = new Heap(new Node.NodeCustomCompare());
			for(Node node : graph) {
				heap.push(node);
			}
			
			int count = 0;
			int i=0;
			
			while(i<n) {
				Node node = heap.pop();
//				System.out.println(node.value + " " + node.degree);

				if(node.degree == 0)
					break;

				for(Node v : node.adjNodes) {
					if(v.index!=-1) {
						v.degree--;
						heap.pushDown(v.index);
					}
				}
				if(!node.lighted) {
					count++;
					node.lighted = true;
				}
				i++;
				
//				heap.printHeap();
			}
			System.out.println(count);
		}
	}
}
