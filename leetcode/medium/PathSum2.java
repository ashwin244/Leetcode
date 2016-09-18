package leetcode.medium;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals
 the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

 */

import java.util.*;
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result =  new ArrayList<>();
    	List<Integer> list = new ArrayList<>();
    	path(result, list, root, sum);
    	return result;
    }
    
    public void path(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {
    	if(root == null) {
    		return;
    	}
    	
    	list.add(root.val);
    	if(root.left == null && root.right == null && sum == root.val) {
    		result.add(new ArrayList<>(list));
    	}
    	else {
    	path(result, list, root.left, sum - root.val);
    	path(result, list, root.right, sum - root.val);
    	}
    	list.remove(list.size() - 1);
    }
}
