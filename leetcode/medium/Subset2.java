package leetcode.medium;

/*
 * 
Given a collection of integers that might contain duplicates, 
nums, return all possible subsets.
 * 
 */
import java.util.*;
public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> list = new ArrayList<>();
    	helper(result, list, nums, 0);
    	return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
    	if(start <= nums.length) {
    		result.add(new ArrayList<>(list));
    	}
    	
    	for(int i=start; i<nums.length; i++) {
    	    if(i > start && nums[i] == nums[i-1]) continue;
    		list.add(nums[i]);
    		helper(result, list, nums, i+1);
    		list.remove(list.size() - 1);
    	}
    }
}
