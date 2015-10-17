package Hashing;

import java.util.Comparator;

public class Node {
	long num;
	long bitcount;
	
	public Node(long n, long b) {
		num = n;
		bitcount = b;
	}

	public static class NodeCompare implements Comparator<Node>{

		@Override
		public int compare(Node n1, Node n2) {
			if(n1.bitcount < n2.bitcount)
				return -1;
			else if(n2.bitcount < n1.bitcount)
				return 1;
			
			return 0;
		}
		
	}
}
