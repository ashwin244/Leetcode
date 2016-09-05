package leetcode.medium;

public class NumMatrix {
	int[][] matrix;
	int[][] sum ;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.sum = new int[matrix.length +1][matrix[0].length + 1];
        sum[0][0] = matrix[0][0];
        for(int i=1; i<=matrix.length; i++) {
        	for(int j=1; j<=matrix[0].length; i++) {
        		sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1]  + sum[row1][col1];
    }
}
