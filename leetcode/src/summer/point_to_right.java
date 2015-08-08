package summer;
//Assume tree is complete

public class point_to_right {
	public static void main(String args[])throws Exception {
		
	}
	public static void connect(Node root) {
		root.next = null;
		glue(root.left, root.right);
		glue(root.right, null);
	}
	public static void glue(Node from, Node to) {
		if(to == null) {
			from.next = null;
			return;	
		}
		from.next = to;
		glue(from.left, from.right);
		if(from.next != null)
			glue(from.right, from.next.left);
		else
			glue(from.right, null);
	}
}
