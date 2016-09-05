package leetcode.medium;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where 
"adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length == 0) {
        	return false;
        }
        
        if(word == null || word.isEmpty()) {
        	return true;
        }
        
        char[] arr = word.toCharArray();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
            		if(search(board, arr, i, j, 0)) {
            			return true;
            		}
            	}
        }
        
        return false;
    }
    
    public boolean search(char[][] board, char[] word, int i, int j, int x) {
    	if(x == word.length) return true;
    	if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 ) {
    		return false;
    	}
    	if(board[i][j] != word[x]) {
    		return false;
    	}
    	board[i][j] ^= 256; //masking
    	boolean exist = search(board, word, i+1, j, x+1) || search(board, word, i, j+1, x+1)
    			|| search(board, word, i-1, j, x+1) ||  search(board, word, i, j-1, x+1);
    	board[i][j] ^= 256; //masking
    	return exist;
    }
}
