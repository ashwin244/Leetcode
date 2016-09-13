package leetcode.medium;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
        	return l2;
        }
        if(l2 == null) {
        	return l1;
        }
        
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;

        while(l1 != null || l2 != null) {

        	if(l1!=null) {
        		carry += l1.val;
        		l1 = l1.next;
        	}
        	if(l2!=null) {
        		carry += l2.val;
        		l2 = l2.next;
        	}
        	p.next = new ListNode(carry%10);
        	carry = carry/10;
        	p = p.next;
        }
        
        if(carry == 1) {
        	p.next = new ListNode(1);
        }
        return head.next;
    }
}
