
public class reverseLinkList {
	public static void main(String args[])throws Exception
	{
		LinkList ll = new LinkList();
		ll.addNode(1);
		ll.addNode(2);
		ll.addNode(3);
		ll.addNode(4);
		ll.addNode(5);
		ll.printList(ll.head);
		ll.reverse(ll.head);
		ll.printList(ll.head);
	}
}
