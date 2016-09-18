package leetcode.medium;

/*
Given a triangle, find the minimum path sum from top to bottom.
 Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	int[] arr = new int[triangle.size() + 1];
    	for(int i = triangle.size()-1; i >= 0 ;i--) {
    		for(int j = 0; j < triangle.get(i).size(); j++) {
        		arr[j] = Math.min(arr[j], arr[j+1]) + triangle.get(i).get(j);
        	}
    	}
    	return arr[0];
    }
}
