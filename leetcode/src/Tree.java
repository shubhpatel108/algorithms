import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	Node root;
	
	
	public Node addNode(Node node, int data) {
		if (node==null) {
			this.root = new Node(data);
			return this.root;
		}
		else {
			if(node.data>data)
			{
				if(node.left==null) {
					node.left = new Node(data);
					return node.left;
				}
				else {
					return addNode(node.left, data);
				}
			}
			else
			{
				if(node.right==null) {
					node.right = new Node(data);
					return node.right;
				}
				else {
					return addNode(node.right, data);
				}
			}
		}
	}
	
	public void printTree(Node node)
	{
		if(node==null) {
			return;
		}
		else {
			System.out.println(node.data);
			printTree(node.left);
			printTree(node.right);
		}
	}
	
	public int maxDepth(Node node, int parent_depth)
	{
		if(node==null)
			return -1;
		else
			return Math.max(Math.max(parent_depth+1, maxDepth(node.left, parent_depth+1)), Math.max(maxDepth(node.right,parent_depth+1),parent_depth+1));
	}
	
	public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root==null)
        	return ans;
        
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(root.data);
        ans.add(temp);
        
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();
        
        q1.add(root);
        
        Node pointer;
        
        while(!q1.isEmpty() || !q2.isEmpty()) 
        {
        	List<Integer> list = new ArrayList<Integer>();
        	while(!q1.isEmpty())
            {
            	pointer = q1.poll();
            	
            	if(pointer.left==null)
            		q2.add(pointer.left);
            	if(pointer.right==null)
            		q2.add(pointer.right);
            	
            	list.add(pointer.data);
            }
        	ans.add(0, list);
        	while(!q2.isEmpty())
        	{
        		q1.addAll(q2);
        		q1 = q2;
        		q2.clear();
        	}
        }
        
        return ans;
    }
	
	public int sumOfAllPaths(Node root)
	{
		ArrayList<String> all_sums = allSums(root);
		int sum = 0;
		
		for(int i=0;i<all_sums.size();i++)
			sum += Integer.parseInt(all_sums.get(i));

		return sum;
	}
	
	public ArrayList allSums(Node root)
	{
		ArrayList<String> left_sums = new ArrayList<String>();
		if(root==null)
			return left_sums;
		
		left_sums = allSums(root.left);
		ArrayList<String> right_sums = allSums(root.right);
		int left_size = left_sums.size();
		int right_size = right_sums.size();
		
		for(int i=0;i<left_size;i++)
		{
			left_sums.set(i, String.valueOf(root.data) + left_sums.get(i)); 
		}
		for(int i=0;i<right_size;i++)
		{
			right_sums.set(i, String.valueOf(root.data) + right_sums.get(i)); 
		}
		for(int i=0;i<right_size;i++)
		{
			left_sums.add(right_sums.get(i)); 
		}
		
		return left_sums;
	}
	
	public void flatten()
	{
		Node root = this.root;
		if(root==null) return;
		
		Stack<Node> stack = new Stack<Node>();
		Node last = null;
		Node pointer;
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			pointer = stack.pop();
			if(last!=null)
			{
				last.right = pointer;
				
			}
			if(pointer.right!=null)
				stack.push(pointer.right);
			if(pointer.left!=null)
				stack.push(pointer.left);
			last = pointer;
		}
	}
}
