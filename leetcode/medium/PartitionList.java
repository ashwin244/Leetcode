package leetcode.medium;

/*
Given a linked list and a value x, partition it such that all nodes less than x
 come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two
 partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
    	if(head == null) {
    		return null;
    	}

    	ListNode p1 = head;
    	ListNode fakeHead1 = new ListNode(0);
    	ListNode fakeHead2 = new ListNode(0);
    	ListNode prev1 = fakeHead1;
    	ListNode p2 = fakeHead2;
    	prev1.next = head;
    	
    	while(p1.next != null) {
    		if(p1.val <= x) {
    			p1 = p1.next;
    			prev1 = prev1.next;
    		}
    		else {
    			p2.next = p1;
    			prev1.next = p1.next;
    			p1 = prev1.next;
    			p2 = p2.next;
    		}
    	}
    	
    	p2.next = null;
    	p1.next = fakeHead2.next;
    	
    	return fakeHead1.next;
    }
}
