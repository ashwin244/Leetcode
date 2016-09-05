package leetcode.medium;
/**
 * 
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 */
public class ReorderList {
    public void reorderList(ListNode head) {
      if(head!=null && head.next !=null) {  
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast!=null && fast.next !=null) {
    		slow =slow.next;
    		fast =fast.next.next;
    	}
    	
    	ListNode second = slow.next;
    	slow.next = null;
    	
    	second = reverse(second);
    	slow = head;
    	
    	while(second!=null) {
    		ListNode temp1 = slow.next;
    		ListNode temp2 = second.next;
    		
    		slow.next = temp2;
    		second.next = temp1;
    		
    		slow = temp1;
    		second = temp2;
    	}
      }
    }
    
    public ListNode reverse(ListNode node) {
    if(node == null || node.next == null) {
    	return node;
    }
    
    	ListNode pre = node;
    	ListNode curr = node.next;
    	
    	while(curr!=null) {
    		ListNode temp = curr.next;
    		curr.next = pre;
    		pre = curr;
    		curr = temp;
    	}
    	node.next = null;
    	return pre;
    }
}
