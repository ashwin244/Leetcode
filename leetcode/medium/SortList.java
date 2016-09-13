package leetcode.medium;

/**
 * 
Sort a linked list in O(n log n) time using constant space complexity.
 *
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next ==  null) {
        	return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = head;
        
        while(p2 != null && p2.next!=null) {
        	pre = p1;
        	p1 = p1.next;
        	p2 = p2.next.next;
        }
        
        pre.next = null;
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(p1);
        
        return merge(n1, n2);
    }
    
    public ListNode merge(ListNode n1, ListNode n2) {
    	if(n1 == null) {
    		return n2;
    	}
    	if(n2 == null) {
    		return n1;
    	}
    	
    	if(n1.val < n2.val) {
    		n1.next =  merge(n1.next, n2);
    		return n1;
    	}
    	
    	else {
    		n2.next =  merge(n1, n2.next);
    		return n2;
    	}
    }
}
