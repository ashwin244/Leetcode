package leetcode.medium;

/*
The thief has found himself a new place for his thievery again. 
There is only one entrance to this area, called the "root." Besides the root, each house
 has one and only one parent house. After a tour, the smart thief realized that "all 
 houses in this place forms a binary tree". It will automatically contact the police 
 if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without 
alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

 */
import java.util.*;
public class HouseRobber3 {
    public int rob(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	
        Map<TreeNode, Integer> map =  new HashMap<>();
        return helper(root, map);
    }
    
    public int helper(TreeNode root, Map<TreeNode, Integer> map) {
    	if(map.containsKey(root)) {
    		return map.get(root);
    	}
    	int val = 0;
    	
    	if(root.left !=null)
    	val += helper(root.left.left, map) + helper(root.left.right, map);
    	
    	if(root.right !=null)
    	val += helper(root.right.left, map) + helper(root.right.right, map);
    	
    	val = Math.max(val + root.val, helper(root.left, map) + helper(root.right, map));
    	map.put(root, val);
    	return val;
    }
    
    
}
