package leetcode.medium;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		return null;
    	}
    	
        return build(nums, 0, nums.length-1);
    }
    
    public TreeNode build(int[] nums, int start, int end) {
    	if(start > end) {
    		return null;
    	}
    	int mid = start + (end - start) /2;
    	TreeNode root = new TreeNode(nums[mid]);
    	TreeNode left = build(nums, start, mid-1);
    	root.left = left;
    	TreeNode right = build(nums, mid+1, end);
    	root.right = right;
    	return root;
    }
}
