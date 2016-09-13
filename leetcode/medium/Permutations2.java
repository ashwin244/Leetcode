package leetcode.medium;

/*
Given a collection of numbers that might contain duplicates, 
return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
import java.util.*;
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) {
        	return result; 
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(result, list, nums, used);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> list, 
    		int[] nums, boolean[] used) {
    	if(list.size() == nums.length) {
    		result.add(new ArrayList<>(list)); 
    		return;
    	}
    	
    	for(int i=0; i<nums.length; i++) {
    		if(used[i]) {
    			continue;
    		}
    		if(i > 0 && nums[i-1] == nums[i] && !used[i-1]) {
    			continue;
    		}
    		used[i] = true;
    		list.add(nums[i]); 
    		dfs(result, list, nums, used);
    		used[i] = false;
    		list.remove(list.size() - 1);
    	}
    	
    }
}
