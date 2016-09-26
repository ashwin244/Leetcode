package leetcode.medium;

import java.util.Collections;

/*
 * 
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 */
import java.util.*;
public class KthLargestElementArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
        for(int n: nums) {
        	queue.add(n);
        }
        k = k-1;
        while(k > 0) {
        	queue.poll();
        	k--;
        }
        return queue.peek();
    }
}
