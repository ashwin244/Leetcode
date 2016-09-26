package leetcode.medium;

import java.util.*;
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	if(root == null) {
    		return result;
    	}
    	Stack<TreeNode> stack = new Stack<>();
    	stack.add(root);
    	while(!stack.isEmpty()) {
    		TreeNode t = stack.peek();
    		if(t.left != null) {
    			stack.push(t.left);
    			t.left = null;
    		}
    		
    		else {
    			result.add(t.val);
    			stack.pop();
    			if(t.right != null) {
    				stack.push(t.right);
    			}
    		}
    	}
    	return result;
    }
}
