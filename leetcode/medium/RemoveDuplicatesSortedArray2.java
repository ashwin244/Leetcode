package leetcode.medium;

public class RemoveDuplicatesSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n: nums) {
        	if(i < 2 || n > nums[i-2]) {
        		nums[i++] = n;
        	}
        }
        return i;
    }
}
