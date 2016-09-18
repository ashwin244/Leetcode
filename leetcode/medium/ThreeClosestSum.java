package leetcode.medium;

import java.util.Arrays;

/*
Given an array S of n integers, find three integers in S such that the sum is closest 
to a given number, target. Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeClosestSum {
	
	public static void main(String[] args) {
		int[] ar = {-1, 2, 1, -4};
		threeSumClosest(ar, 1);
	}
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
    	int result = Integer.MAX_VALUE;;
        for(int i =0; i< nums.length - 2; i++) {
        	int j = i+1;
        	int k = nums.length - 1;
        	while(j < k) {
        		int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(sum - target) ==0) {
                    return sum;
                }
                if(Math.abs(sum-target) < Math.abs(result-target)) {
                	result = sum;
                }
        	}
        }
        
        return result;
    }
}
