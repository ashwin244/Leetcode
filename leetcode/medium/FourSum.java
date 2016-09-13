package leetcode.medium;

/*
Given an array S of n integers, are there elements a, b, c, and d in S such 
that a + b + c + d = target? Find all unique quadruplets in the array which 
gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> result =  new ArrayList<>();
    	if(nums.length < 4) return result;
    	
    	Arrays.sort(nums);
        for(int i=0; i<nums.length - 3; i++) {
        	if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<nums.length - 2; j++) {
            	if(j > i+1 && nums[j] == nums[j-1]) continue;
            	int low = j+1, high =  nums.length - 1; 
            	while(low < high) {
            		int sum = nums[i] + nums[j] + nums[low] + nums[high];
            		
            		if(sum == target) {
            			result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high])); 
                		while(low < high  && nums[low] == nums[low+1]) low++;
                		while(low < high  && nums[high] == nums[high-1]) high--;
                		low++;
                		high--;
            		}
            		else if(sum < target) {
            			low++;
            		}
            		else {
            			high--;
            		}
            	}
            }
        }
        
        return result;
    }
}
