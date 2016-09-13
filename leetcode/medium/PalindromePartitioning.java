package leetcode.medium;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 */
import java.util.*;
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<=i; j++) {
            	if((s.charAt(i) == s.charAt(j)) && (i-j <= 2 || dp[j+1][i-1])) {
            		dp[i][j] = true;
            	}
            }
        }
        helper(result, s, 0, list, dp);
        return result;
    }
    
    public void helper(List<List<String>> result, String s, int index, List<String> list, boolean[][] dp) {
    	if(index == s.length()) {
    		result.add(new ArrayList<>(list)); 
    		return;
    	}
    	for(int i=index; i<s.length(); i++) {
    		if(dp[index][i]) {
    			list.add(s.substring(index, i+1));
    			helper(result, s, index + 1, list, dp);
    			list.remove(list.size() - 1);
    		}
    	}
    }
}
