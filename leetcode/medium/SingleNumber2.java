package leetcode.medium;

public class SingleNumber2 {
	public static void main(String[] args) {
		int[] a = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4};
		singleNumber(a);
	}
    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        
        for(int i: nums) {
        	ones = (ones ^ i) & ~twos;
        	twos = (twos ^ i) & ~ones;
        }
        
        return ones;
    }
}
