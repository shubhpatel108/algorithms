
public class AVLController {
	public static void main(String[] args)throws Exception {
		AVLTree tree = new AVLTree();
		tree.insert(5);

		tree.insert(3);

		tree.insert(4);

		tree.traverse(tree.root);
	}
}
