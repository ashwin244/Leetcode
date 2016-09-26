package leetcode.medium;

/*
Given an unsorted array return whether an increasing subsequence of length 
3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.
 */
public class IncreasingTriplets {
    public boolean increasingTriplet(int[] nums) {
        int large = Integer.MAX_VALUE, small = Integer.MAX_VALUE;
        for(int n: nums) {
        	if(n <= small) {
        		small = n;
        	}
        	else if(n <= large) {
        		large = n;
        	}
        	else return true;
        }
        return false;
    }
}
