/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class FindCycleNode {
    public Node detectCycle(Node head) {

	ListNode fast = head;
	ListNode slow = head;

	while(fast!=null && slow!=null && fast.next!=null) {
    	fast = fast.next.next;
    	slow = slow.next;
    
    	if(fast == slow) {
    		return intersectionNode(fast, head);
        }
    }

    return null;
}

public ListNode intersectionNode(ListNode loopNode, ListNode head) {
	int k = lengthOfLoop(loopNode);

	ListNode pointer1 = head;
	ListNode pointer2 = head;
	int count = 1;

	while(count!=k) {
		pointer2 = pointer2.next;
        count++;
    }
    
    while(pointer1 == pointer2) {
    	pointer1 = pointer1.next;
        pointer2 = pointer2.next;
    }
    return pointer1;
}

public int lengthOfLoop(ListNode loopNode) {
    if(loopNode == null) 
        return 0;	
    
    int count = 1;
	ListNode pointer = loopNode.next;
    	
    while(pointer!=loopNode) {
    	count++;
        pointer = pointer.next;
    }
    return count;
}

}