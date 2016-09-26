package leetcode.medium;

/**
 *
Given n pairs of parentheses, write a function to generate all 
combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
] 
 * @author ASHWIN
 *
 */
import java.util.*;
public class GenerateParantheses {
    public List<String> generateParenthesis(int n) {
    	List<String> res = new ArrayList<>();
        helper(res, "", n, 0);
        return res;
    }
    
    public void helper(List<String> res, String s, int n, int m) {
    	if(m==0 && n==0) {
    		res.add(s);
    		return;
    	}
    	
    	if(m > 0)
    	helper(res, s + ")", n, m-1);
    	
    	if(n > 0)
    	helper(res, s + "(", n-1, m+1);
    	
    }
}
