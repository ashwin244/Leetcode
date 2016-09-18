package leetcode.medium;

/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }
    
    public int[] search(int[] nums, int start, int end, int target) {
    	if(nums[start] == target && nums[end] == target) {
    		return new int[]{start, end};
    	}
    	if(nums[start] <= target && nums[end] >= target) {
    		int mid = start + (end - start)/2;
    		int[] lo = search(nums, start, mid, target);
    		int[] hi = search(nums, mid+1, end, target);
    		
    		if(lo[0] ==  -1) return hi;
    		if(hi[0] ==  -1) return lo;
    		
    		return new int[]{lo[0], hi[1]}; 
    	}
    	return new int[]{-1, -1};
    }
}
