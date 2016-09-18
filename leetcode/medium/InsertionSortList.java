package leetcode.medium;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode curr = head;
		ListNode pre = newHead;

		while (curr != null) {
			if (curr.next != null && curr.next.val < curr.val) {
				while (pre.next != null && pre.next.val < curr.next.val) {
					pre = pre.next;
				}

				ListNode temp = pre.next;
				pre.next = curr.next;
				curr.next = curr.next.next;
				pre.next.next = temp;
				pre = newHead;
			}

			else {
				curr = curr.next;
			}
		}

		return newHead.next;
	}
}
