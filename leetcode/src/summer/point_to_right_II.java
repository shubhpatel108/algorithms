package summer;
//Accepted. Tree here might not be complete.
import java.util.Stack;

public class point_to_right_II {
	static Stack<Node> lefts = new Stack<Node>();
	static Tree bt;
	public static void main(String args[])throws Exception
	{
		bt = new Tree();
		bt.addNode(bt.root, 2);
		bt.addNode(bt.root, 1);
		bt.addNode(bt.root, 3);
		glue(bt.root);
	}
	public static void glue(Node head)
	{
		if(head==null)
			return;
		
		if(lefts.isEmpty())
			head.right = null;
		else
			head.right = lefts.pop();
		
		glue(head.right);
		glue(head.left);
		lefts.push(head);
		return;
	}
}
