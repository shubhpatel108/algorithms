//Seems correct. But to be made efficient.
package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class HuffmanCoding {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String s = input.readLine();
		int len = s.length();
		int[] freq = new int[26];
		
		for(int i=0;i<len;i++) {
			freq[(int)Character.toLowerCase(s.charAt(i)) - 97]++;
		}
		
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(1, new HuffmanNode.HuffmanNodeCompare());
		
		for(int i=0;i<26;i++) {
			if(freq[i]!=0) {
				q.add(new HuffmanNode((char)(i + 97), freq[i]));
			}
		}
		
		while(q.size() > 1) {
			HuffmanNode n1 = q.poll();
			HuffmanNode n2 = q.poll();
			HuffmanNode newNode = new HuffmanNode(n1.freq + n2.freq);
			newNode.left = n1;
			newNode.right = n2;
			
			q.add(newNode);
		}
		StringBuilder code = new StringBuilder();
		DFS(q.peek(), code);
	}
	
	public static void DFS(HuffmanNode node, StringBuilder code) {
		if(node == null)
			return;

		if(node.left == null && node.right==null) {
			node.code = code.toString();
			System.out.println(node.character + " : " + node.code);
			return;
		}
		
		if(node.left != null) {
			code.append('0');
			DFS(node.left, code);
			code.deleteCharAt(code.length() - 1);
		}
		
		if(node.right != null) {
			code.append('1');
			DFS(node.right, code);
			code.deleteCharAt(code.length() - 1);
		}
	}
}
