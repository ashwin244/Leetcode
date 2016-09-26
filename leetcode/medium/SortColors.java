package leetcode.medium;

/**
 * 
 * 
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, 
and blue respectively. 
 *
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int two = nums.length - 1;
        int zero = 0;
        for(int i = zero; i <= two; ) {
        	
        	if(nums[i] == 0) {
        		int temp = nums[i];
        		nums[i] = nums[zero];
        		nums[zero] = temp;
        		i++;
        		zero++;
        	}
        	
        	else if(nums[i] == 2) {
        		int temp = nums[i];
        		nums[i] = nums[two];
        		nums[two] = temp;
        		two--;
        	}
        	
        	else {
        		i++;
        	}
        }
    }
}
