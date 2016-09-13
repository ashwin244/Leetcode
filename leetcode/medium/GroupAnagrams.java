package leetcode.medium;

/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
 */
import java.util.*;
public class GroupAnagrams {
	public static void main(String[] args) {
		String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagrams(arr);
	}
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String s : strs) {
        	String t = s;
        	char[] arr = s.toCharArray();
        	Arrays.sort(arr); 
        	s = new String(arr);
        	if(!map.containsKey(s)) {
        		List<String> list = new ArrayList<>();
        		map.put(s, list);
        	}
        		map.get(s).add(t);
        }
        
        for(List<String> list : map.values()) {
        	result.add(list);
        }
        return result;
    }
    
}
