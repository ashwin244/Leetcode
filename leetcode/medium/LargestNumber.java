package leetcode.medium;

/**
 * 
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */
import java.util.*;

class StringComparator implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		return (b.concat(a)).compareTo(a.concat(b));
	}
}

public class LargestNumber {
	public static void main(String[] args) {
		int[] arr = { 0, 0 };
		largestNumber(arr);
	}

	public static String largestNumber(int[] nums) {
		String[] str = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			str[i] = nums[i] + "";
		}
		Arrays.sort(str, new StringComparator());

		String result = "";
		for (String s : str) {
			result = result + s;
		}
		
		while(result.charAt(0) == '0' && result.length() > 1) {
			result = result.substring(1);
		}
		return result;
	}
}
