package leetcode.hard;

import java.util.*;

class Trie {
	String word;
	Trie[] next = new Trie[26]; 
}

public class WordSearch2 {
	
	
    public static List<String> findWords(char[][] board, String[] words) {
        Trie t = buildTrie(words);
        List<String> res = new ArrayList<>();
        for(int i=0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		search(board, i, j, t, res);
        	}
        }
        return res;
    }
    
    public static void search(char[][] board, int i, int j, Trie p, List<String> result) {
    	char temp = board[i][j];
    	if(temp == '#' || p.next[temp-'a'] == null) {
    		return;
    	}
    	
    	p = p.next[temp-'a'];
    	
    	if(p.word != null) {
    		result.add(p.word);
    		p.word = null;
    	}
    	
    	board[i][j] = '#';
    	if(i > 0) 					 search(board, i-1, j, p, result);
    	if(j > 0) 					 search(board, i, j-1, p, result);
    	if(i < board.length - 1) 	 search(board, i+1, j, p, result);
    	if(j < board[0].length - 1)  search(board, i, j+1, p, result);
    	
    	board[i][j] = temp;
    }
    
    public static Trie buildTrie(String[] words)  {
    	Trie root = new Trie();
    	for(String w : words) {
    		Trie p = root;
    		for(char c : w.toCharArray()) {
    			int i = c - 'a';
    			if(p.next[i] == null)  {
    				p.next[i] = new Trie();
    			}
    			p = p.next[i];
    		}
    		p.word = w;
    	}
    	return root;
    }
    
}
