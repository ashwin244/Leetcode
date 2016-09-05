package leetcode.medium;

/**
 * 
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 *
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class RotateLIst {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null) {
    		return null;
    	}
    	ListNode p = head;
    	int len = 1;
    	while(p.next != null) {
    		p = p.next;
    		len++;
    	}
    	p.next = head; //circular
    	k = k%len;
    	for(int i=0; i<len-k; i++) {
    		p = p.next;
    	}
    	head = p.next;
    	p.next = null;
    	
    	
    	return head;
    } 
    
}
