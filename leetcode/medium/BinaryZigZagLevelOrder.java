package leetcode.medium;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
import java.util.*;
public class BinaryZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
    	if(root == null) {
    		return result;
    	}
        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        curr.add(root);
        List<Integer> list = new ArrayList<>();
        boolean isForward = false;
        while(!curr.isEmpty()) {
        	TreeNode pop = curr.poll();
        	
        	if(pop.left!=null) {
        		next.add(pop.left);
        	}
        	if(pop.right!=null) {
        		next.add(pop.right);
        	}
        	
        	if(isForward) {
        		list.add(0, pop.val);
        	}
        	else {
        		list.add(pop.val);
        	}
        	if(curr.isEmpty()) {
        		isForward = !isForward;
        		result.add(list);
        		curr = next;
        		list = new ArrayList<>();
        		next = new LinkedList<>();
        	}
        }
        return result;
    }
}
