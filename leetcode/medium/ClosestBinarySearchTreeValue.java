package leetcode.medium;

public class ClosestBinarySearchTreeValue {
	int goal;
	double min = Double.MAX_VALUE;
	public int closestValue(TreeNode root, double target) {
		helper(root, target);
		return goal;
	}
	
	public void helper(TreeNode root, double target) {
		if(root == null) {
			return;
		}
		
		if(Math.abs(root.val - target) < min) {
			min = Math.abs(root.val - target);
			goal = root.val;
		}
		
		if(root.val > target) {
			helper(root.left, target);
		}
		
		else {
			helper(root.right, target);
		}
	}
}
