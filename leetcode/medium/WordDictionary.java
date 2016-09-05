package leetcode.medium;

class TrieNode {
	public String word="";
	public TrieNode[] children = new TrieNode[26];
}


public class WordDictionary {
	TrieNode root =  new TrieNode();
	
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] arr = word.toCharArray();
        TrieNode node = root;
        for(char c:arr) {
        	if(node.children[c-'a'] == null) {
        		node.children[c-'a'] = new TrieNode();
        	}
        	node = node.children[c-'a'];
        }
        
        node.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return match(word.toCharArray(), root, 0);
    }
    
    public boolean match(char[] arr, TrieNode node, int k) {
    	if(arr.length == k) {
    		return !node.word.equals("");
    	}
    	
    	if(arr[k] != '.') {
    		return node.children[arr[k] - 'a'] != null || match(arr, node.children[arr[k]-'a'], k+1);
    	}
    	else {
    		for(int i=0; i < node.children.length; i++) {
    			if(node.children[i] != null) {
    				if(match(arr, node.children[i], k+1)) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
}
