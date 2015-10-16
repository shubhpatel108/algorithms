//TLE. Original Solution is using Fermet thm.
package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class D311 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		SegmentTree tree = new SegmentTree(arr, n);
//		tree.traverse(tree.root);
		int k = Integer.parseInt(input.readLine());
		
		while(k-->0) {
			tokens = input.readLine().split(" ");
			if(tokens[0].equals("1")) {
				BigInteger ans = tree.query(tree.root, Integer.parseInt(tokens[1]) - 1, Integer.parseInt(tokens[2]) - 1);
				System.out.println(ans);
			} else {
				tree.update(tree.root, Integer.parseInt(tokens[1]) - 1, Integer.parseInt(tokens[2]) - 1);
//				tree.traverse(tree.root);
			}
		}
	}
}
