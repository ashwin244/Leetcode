package leetcode.medium;

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
import java.util.*;

public class SummaryRanges {
	public static void main(String[] args) {
		int[] nums = { 1, 3 };
		summaryRanges(nums);
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			while (i < nums.length - 1 && nums[i + 1] == nums[i] + 1) {
				i++;
			}
			String s = num + "";
			if (num != nums[i]) {
				s += "->" + nums[i];
			}
			list.add(s);
		}
		return list;
	}
}
