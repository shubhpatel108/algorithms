
public class LinkList {
	Node head;
	public void addNode(int data) {
		if(head==null)
		{
			head = new Node(data);
			return;
		}
		Node pointer = head;
		while(pointer.next!=null)
			pointer = pointer.next;
		
		pointer.next = new Node(data);
		return;
	}
	
	public void printList(Node head)
	{
		Node pointer = head;
		while(pointer!=null)
		{
			System.out.println(pointer.data);
			pointer = pointer.next;
		}
	}
	
	public Node reverse(Node head)
	{
		if(head!=null)
			return null;
		
		Node prev = null;
		Node current = head;
		Node next;
		
		while(current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		this.head = prev;
		
		return this.head;
	}
}
