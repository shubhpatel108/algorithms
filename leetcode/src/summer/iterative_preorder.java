package summer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class iterative_preorder {
	
	public static void main(String args[])throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int treeElements[] = {5,3,6,1,2};
		Tree tree = new Tree();
		for(int e: treeElements) {
			tree.addNode(tree.root, e);
		}
		preorderTraversal(tree.root);
	}
	
	public static List<Integer> preorderTraversal(Node root) {
        List<Integer> list = new ArrayList<Integer>();
		if(root==null)
        	return list;
		Stack stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
        	Node node = (Node)stack.pop();
        	list.add(node.data);
        	if(node.right != null)
        		stack.push(node.right);
        	if(node.left != null)
        		stack.push(node.left);
        }
        return list;
    }
}
