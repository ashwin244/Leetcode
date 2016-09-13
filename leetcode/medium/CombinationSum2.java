package leetcode.medium;

/**
 * 
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 *
 */
import java.util.*;
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> list = new ArrayList<>();
    	Arrays.sort(candidates);
    	dfs(result, list, candidates, target, 0);
    	return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> list, int[] candidates, 
    		int target, int index) {
    	if(target == 0) {
    		result.add(new ArrayList<>(list));
    		return;
    	}
    	if(target < 0) {
    		return;
    	}
    	
    	for(int i=index; i<candidates.length; i++) {
    		if(i > index && candidates[i-1] == candidates[i]) {
    			continue;
    		}
    		list.add(candidates[i]);
    		dfs(result, list, candidates, target - candidates[i], i+1);
    		list.remove(list.size() - 1);
    	}
    	
    }
}
