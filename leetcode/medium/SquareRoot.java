package leetcode.medium;

public class SquareRoot {
	public static void main(String[] args) {
		System.out.println(mySqrt(9));  
	}
    public static int mySqrt(int x) {
        if(x==0) {
        	return 0;
        }
        int left = 1, right  = x;
        
        while(left < right) {
        	int mid = left + (right - left)/2;
        	if(mid <= x / mid) {
        		left = mid +1;
        	}
        	else {
        		right  = mid - 1;
        	}
        }
        
        return left - 1;
    }
}
