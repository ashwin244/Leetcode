package leetcode.medium;

/**
 * 
 * 
Given n non-negative integers a1, a2, ..., an, where each represents a
 point at coordinate (i, ai). n vertical lines are drawn such that the two
  endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
   with x-axis forms a container, such that the container contains the most water.
 *
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int h = 0, water = 0;
        while(i < j) {
        	 h = Math.min(height[i], height[j]);
        	water = Math.max(water, h*(j-i));
        	
        	while(height[i] < h) i++;
        	while(height[j] < h) j--;
        }
        
        return water;
    }
}
