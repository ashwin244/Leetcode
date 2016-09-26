package leetcode.medium;

/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination 
should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 */

import java.util.*;
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
    	List<Integer> list = new ArrayList<>();
    	List<List<Integer>> result = new ArrayList<>();
    	helper(result, list, n, k, 1);
    	
    	return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> list, int n, int k, int start) {
    	if(list.size() == k && n == 0) {
    		result.add(new ArrayList<>(list));
    		return;
    	}
    	
    	for(int i=start; i<=9; i++) {
    		list.add(i);
    		helper(result, list, n-i, k, i+1);
    		list.remove(list.size() - 1);
    	}
    }
}
