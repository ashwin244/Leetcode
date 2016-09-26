package leetcode.medium;

import java.util.NavigableSet;

/*
 * 
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you
 to return the length.

Your algorithm should run in O(n2) complexity.

 */
import java.util.*;
public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		lengthOfLIS(arr);
	}
    public static int lengthOfLIS(int[] nums) {
    	NavigableSet<Integer> s = new TreeSet<>();
    	for(int n: nums) {
    		if(!s.add(n)) {
    			continue;
    		}
    		Integer it = s.higher(n);
    		if(it != null) {
    			s.remove(it);
    		}
    	}
    	return s.size();
    }
}
