package leetcode.medium;

/*
 * 
Given an integer n, generate a square matrix filled with elements from 1 to n2 
in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * 
 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int k = 0;
        int i = 0;
        while(k <= n*n) {
        	
        	int j = i;
        	while(j < n-i) {
        		arr[i][j++] = k++;
        	}
        	j = i+1;
        	while(j < n-i) {
        		arr[j++][n-i-1] = k++;
        	}
        	j = n-i-2;
        	while(j > i) {
        		arr[n-i-1][j--] = k++;
        	}
        	j = n-i-1;
        	while(j > i) {
        		arr[j--][i] = k++;
        	}
        	i++;
        }
        return arr;
    }
}
