
public class Controller {
	public static void main(String args[])throws Exception {
		BinarySearchTree bst = new BinarySearchTree();
		int[] arr = {5,2,6,4,1,-1};
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			Node node = new Node(arr[i]);
			bst.addNode(bst.root, node);
		}
		System.out.println(bst.minimum(bst.root).data);
		System.out.println(bst.maximum(bst.root).data);
	}
}
