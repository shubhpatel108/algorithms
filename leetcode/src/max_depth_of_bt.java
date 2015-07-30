
public class max_depth_of_bt {
	public static void main(String args[])throws Exception
	{
		try{
			int treeElements[] = {69,73,68,18,20,18,39,7,-3,13,-1,42,5,93,70,63,17};
			Tree tree = new Tree();
			for(int e: treeElements) {
				tree.addNode(tree.root, e);
			}
//			System.out.println(tree.maxDepth(tree.root, -1));
			tree.printTree(tree.root);
			System.out.println("=======");
			tree.flatten();
			tree.printTree(tree.root);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
