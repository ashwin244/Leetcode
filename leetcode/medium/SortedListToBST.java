package leetcode.medium;

public class SortedListToBST {
	ListNode list;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
        	return null;
        }
        ListNode p = head;
        list = head;
        int count = 0;
        while(p!=null) {
        	p = p.next;
        	count++;
        }
        return convert(0, count-1); 
    }
    
    public TreeNode convert(int start, int end) {
    	if(start  > end) {
    		return null;
    	}
    	
    	int mid =  start + (end - start) /2;
    	
    	TreeNode left = convert(start, mid - 1);
    	
    	TreeNode root = new TreeNode(list.val);
    	root.left = left;
    	list = list.next;
    	TreeNode right = convert(mid + 1, end);
    	root.right = right;
    	
    	return root;
    }
}
