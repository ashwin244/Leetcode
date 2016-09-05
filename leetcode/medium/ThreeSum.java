package leetcode.medium;

/**
 * 
Given an array S of n integers, are there elements a, b, c in S such that 
a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 *
 */
import java.util.*;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int j = i + 1;
				int k = nums.length - 1;

				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];

					if (sum == 0) {
						result.add((Arrays.asList(nums[i], nums[j], nums[k])));
						while (j < k && nums[k] == nums[k - 1])
							k--;
						while (j < k && nums[j] == nums[j + 1])
							j++;
					} else if (sum < 0) {
						j++;
					} else {
						k--;
					}
				}
			}
		}
		return result;
	}
	
}
