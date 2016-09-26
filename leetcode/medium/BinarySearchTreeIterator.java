package leetcode.medium;

/*
 * 
Implement an iterator over a binary search tree (BST). 
Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
where h is the height of the tree. 
 *
 */
import java.util.*;
public class BinarySearchTreeIterator {
	Stack<TreeNode> stack = new Stack<>();
    public BinarySearchTreeIterator(TreeNode root) {
    	push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode s = stack.pop();
        push(s.right);
        return s.val;
    }
    
    public void push(TreeNode root) {
        while(root!= null) {
        	stack.push(root);
        	root = root.left;
        }
    }
}
