package leetcode.medium;

/*
 * 
 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 */
public class KthSmallestElementSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
    	int m = matrix.length;
        int lower = matrix[0][0];
        int higher = matrix[m-1][m-1];
        
        while(lower < higher) {
        	int mid = lower + (higher - lower)/2;
        	
        	int count = count(matrix, mid);
        	
        	if(count >= k) {
        		higher = mid;
        	}
        	else {
        		lower = mid + 1;
        	}
        }
        return higher;
    }
    
    public int count(int[][] matrix, int target) {
    	int m = matrix.length;
    	int i = m-1;
    	int j = 0;
    	int count  = 0;
    	while(i >=0 && j < m) {
    		if(matrix[i][j] <= target) {
    			count += i+1;
    			j++;
    		}
    		else {
    			i--;
    		}
    	}
    	return count;
    }
}
