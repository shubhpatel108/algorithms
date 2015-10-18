//TLE in some cases
package SegmentTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoVsThree {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String s = input.readLine();
		Tree tree = new Tree(s);
//		tree.traverse(tree.root);

		int m = Integer.parseInt(input.readLine());

		while(m-->0) {
			String[] tokens = input.readLine().split(" ");
			if(tokens[0].equals("0")) {
				String ans = tree.query(tree.root, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
				System.out.println(binaryToReducedNum(ans.toCharArray(), ans.length()));
			} else {
				tree.update(tree.root, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[1]));
//				System.out.println(tree.root.value);
			}
		}
	}

	public static int binaryToReducedNum(char[] s, int length) {
		int num = 0;
		for(int i=0;i<length;i++) {						
			if(s[i]=='1') {
				int rem = ((length-1-i) % 2 == 0)? 1:2;
				num = (num+rem);
			}
		}
		return num%3;
	}
}
