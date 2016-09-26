package leetcode.medium;

/*
 * 
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 * 
 */
public class SearchRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        
        while(start <= end) {
        	int mid = start + (end - start) /2;
        	
        	if(nums[mid] == target) {
        		return true;
        	}
        	
        	if(nums[mid] > nums[end]) {
        		if(nums[mid] > target && nums[start] <= target) end = mid;
        		else start = mid + 1;
        	}
        	
        	
        	else if(nums[mid] < nums[end]) {
        		if(nums[mid] < target && nums[end] >= target) start = mid+1;
        		else end = mid;
        	}
        	
        	else {
        		end--;
        	}
        }
        return nums[start] == target;
    }
}
