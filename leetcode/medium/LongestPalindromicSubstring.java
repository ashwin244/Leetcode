package leetcode.medium;

/**
 * 
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000,
 and there exists one unique longest palindromic substring.
 *
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("forgeeksskeegfor"));
	}
	
	public static String longestPalindrome(String s) {
		boolean[][] L = new boolean[s.length()][s.length()];
		
		for(int i=0; i < s.length(); i++) {
			L[i][i] = true;
		}
		
		int start = 0;
		int len = 1;
		for(int i=0; i < s.length() - 1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				L[i][i+1] = true;
				start = i;
				len = 2;
			}
		}
		
		for(int i=3; i <= s.length(); i++) {
			for(int j=0; j < s.length() - i + 1; j++) {
				int k = i+j-1;
				if(s.charAt(j) == s.charAt(k) && L[j+1][k-1]) {
					L[j][k] = true;
					
					if(i > len) {
						start = j;
						len = i;
					}
				}
			}
		}
		return s.substring(start, start+len);
	}
}
