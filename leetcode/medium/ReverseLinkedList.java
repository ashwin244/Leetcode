package leetcode.medium;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
        	return null;
        }
        
        ListNode pre =null;
        ListNode curr = head;
        ListNode next;
        
        while(curr.next != null) {
        	next = curr.next;
        	curr.next = pre;
        	pre = curr;
        	curr = next;
        }
        return pre;
    }
}
