//Still pending the main logic
import java.io.*;
public class symmetric_tree {
	public static void main(String args[])throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int treeElements[] = {1,1,1,1,1};
		Tree tree = new Tree();
		for(int e: treeElements) {
			tree.addNode(tree.root, e);
		}
		System.out.println(isSymmetric(tree.root));
	}
	
	public static boolean isSymmetric(Node root) {
		if(root==null)
			return true;
		
		return compare(root.left, root.right);
	}
	
	public static boolean compare(Node node1, Node node2) {
		if(node1==null && node2==null)
			return true;
		
		
		if(node1!=null && node2!=null)
		{
			return (node1.data==node2.data) && compare(node1.left, node2.right) && compare(node1.right, node2.left);
		}
		else return false;
	}
}
