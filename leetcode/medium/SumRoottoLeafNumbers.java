package leetcode.medium;

/*
 * 
Given a binary tree containing digits from 0-9 only, each root-to-leaf path 
could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 * 
 */
import java.util.*;
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        int sum = 0;
        
        Stack<TreeNode>stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode t = stack.pop();
        	
        	if(t.right != null) {
        		t.right.val = t.val * 10  + t.right.val;
        		stack.push(t.right);
        	}
        	if(t.left != null) {
        		t.left.val = t.val * 10  + t.left.val;
        		stack.push(t.left);
        	}
        	
        	if(t.left == null && t.right == null) {
        		sum += t.val;
        	}
        }
        
        return sum;
    }
}
