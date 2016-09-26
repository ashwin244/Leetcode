package leetcode.medium;

/**
 * 
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 *
 */

import java.util.*;
public class Permutations {
	   public List<List<Integer>> permute(int[] nums) {
			   List<Integer> list = new ArrayList<>();
			   List<List<Integer>> result = new ArrayList<>();
			   helper(result, list, nums, 0);
			   return result;
		    }
		   
		   public void helper(List<List<Integer>> result,  List<Integer> list, int[] nums, int start) {
			   if(start == nums.length) {
				   result.add(new ArrayList<>(list));
				   return;
			   }
			   
			   for(int i = 0; i < list.size(); i++) {
				   if(list.contains(nums[i])) continue;
				   list.add(nums[i]);
				   helper(result, list, nums, start + 1);
				   list.remove(list.size()-1);
			   }
		   }
}
