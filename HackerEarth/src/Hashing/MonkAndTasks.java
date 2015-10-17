//TLE
package Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MonkAndTasks {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			Node[] arr = new Node[n];
			tokens = input.readLine().split(" ");
			
			for(int i=0;i<n;i++) {
				long num = Long.parseLong(tokens[i]);
				Node node = new Node(num, Long.bitCount(num));
				arr[i] = node;
			}
			Arrays.sort(arr, new Node.NodeCompare());
			
			for(Node node : arr) {
				System.out.print(node.num + " ");
			}
			System.out.println();
		}
	}
}
