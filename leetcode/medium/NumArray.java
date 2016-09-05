package leetcode.medium;

/**
 * 
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.

http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/

 *
 */
public class NumArray {

	int[] arr;
	int[] BIT;
	int n;
    public NumArray(int[] nums) {
        arr = nums;
        n = nums.length;
        BIT = new int[n + 1];
        
        for(int i=0; i<nums.length; i++) {
        	init(i, nums[i]);
        }
    }

    private void init(int i, int val) {
    	i++;
    	while(i<= n) {
    		BIT[i] += val;
    		i += (i & -i);
    	}
    }
    
    void update(int i, int val) {
    	arr[i] = val;
    	init(i, val - arr[i]);
    }

    public int sumRange(int i, int j) {
    	int sumI=0, sumJ = 0;
    	while(i > 0) {
    		sumI += BIT[i];
    		i -= (i & -i); 
    	}
    	
    	j++;
    	while(j > 0) {
    		sumJ += BIT[j];
    		j -= (j & -j); 
    	}
    	
    	return sumJ - sumI;
    }

}
