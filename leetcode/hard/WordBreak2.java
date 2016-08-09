package leetcode.hard;
import java.util.*;
/**
 * 
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 *
 */
public class WordBreak2 {
	
	public static void main(String[] args) {
		WordBreak2 w = new WordBreak2();
		Set<String> set= new HashSet<>();
		set.add("cat");set.add("cats");set.add("and");set.add("sand");set.add("dog");
		
		w.wordBreak("catsanddog", set);
	}
	
    Map<String, LinkedList<String>> m = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {        
        if(m.containsKey(s)) {
        	return m.get(s);
        }
        
        LinkedList<String> res = new LinkedList<>();
        if(s.length() == 0)  {
        	res.add("");
        	return res;
        }
        
        for(String w : wordDict) {
        	if(s.startsWith(w)) {
        		List<String> subList = wordBreak(s.substring(w.length()), wordDict);
        		for(String sub: subList) {
        			res.add(w.concat(sub.isEmpty()? "" : " ").concat(sub));
        		}
        	}
        }
        
        m.put(s, res);
        return res;
    }
}
