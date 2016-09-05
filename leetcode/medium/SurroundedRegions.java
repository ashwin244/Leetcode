package leetcode.medium;

/**
 * 
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions 
surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 *
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
    	if (board.length < 2 || board[0].length < 2)
    		return;
    	
        for(int i=0; i<board.length; i++) {
            	if(board[i][0] == 'O') 
            		merge(i, 0, board);
            	if(board[i][board[0].length-1] == 'O') 
            		merge(i, board[0].length-1, board);
        }
        
        for(int j=0; j<board[0].length; j++) {
        	if(board[0][j] == 'O') 
        		merge(0, j, board);
        	if(board[board.length-1][j] == 'O') 
        		merge(board.length-1, j, board);
        }
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == '*') {
					board[i][j] = 'O';
				}
				else if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
    }
    
    public void merge(int i, int j, char[][] board) {
    	if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) {
    		return;
    	}
    	
    	if(board[i][j] == 'O') 
    		board[i][j] = '*';
    	
    		if(i>1 && board[i-1][j] == 'O')
    			merge(i-1, j, board);
    		if(j>1 && board[i][j-1] == 'O')
    			merge(i, j-1, board);
    		if(i<board.length-2 && board[i+1][j] == 'O')
    			merge(i+1, j, board);
    		if(j<board[0].length-2 && board[i][j+1] == 'O')
    			merge(i, j+1, board);
    }
}
