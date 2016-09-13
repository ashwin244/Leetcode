package leetcode.medium;

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.
 */
public class ReverseList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
        	return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=0; i<m-1; i++) {
        	pre = pre.next;
        }
        
        ListNode start = pre.next;
        ListNode curr = start.next;
        
        for(int i=0; i<n-m; i++) {
        	start.next = curr.next;
        	curr.next = pre.next;
        	pre.next = curr;
        	curr = start.next;
        }
        
        return dummy.next;
    }
}
