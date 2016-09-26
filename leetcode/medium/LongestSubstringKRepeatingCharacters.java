package leetcode.medium;

/*
 * 
Find the length of the longest substring T of a given string 
(consists of lowercase letters only) such that every character in T 
appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
 repeated 3 times.
 * 
 * 
 */
public class LongestSubstringKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(n < k) {
        	return 0;
        }
        if(k ==1) {
        	return n;
        }
        
       int[] count = new int[26];
       for(char c: s.toCharArray()) {
    	   count[c-'a']++;
       }
       char b = 0;
       for(int i=0; i<26; i++) {
    	   if(count[i] > 0 && count[i] < k) {
    		   b = (char) (i + 'a');
    		   break;
    	   }
       }   
    	   if(b == 0) return n;
    	   int res = 0;
    	   String[] str = s.split(b+"");
    	   for(String sub: str) {
    		   res = Math.max(res, longestSubstring(sub, k));
    	   }
    	   
    	   return res;
    }
}
