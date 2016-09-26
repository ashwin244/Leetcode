package leetcode.medium;

/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside 
the square brackets is being repeated exactly k times. Note that k is guaranteed 
to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, 
square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any 
digits and that digits are only for those repeat numbers, k. For example, 
there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 */

import java.util.*;
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> inInt = new Stack<>();
        Stack<StringBuilder> inStr = new Stack<>();
        
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for(char c: s.toCharArray()) {
        	if(Character.isDigit(c)) {
        		k = k*10 + (c - '0');
        	}
        	
        	else if(c == '['){
        		inInt.push(k);
        		inStr.push(cur);
        		cur = new StringBuilder();
        		k=0;
        	}
        	
        	else if(c==']') {
        		StringBuilder temp = cur; //current string to be encoded
        		cur = inStr.pop(); // previous encoded
        		
        		for(k = inInt.pop(); k>0; k--) {
        			cur.append(temp); 
        		}
        	}
        	
        	else {
        		cur.append(c);
        	}
        }
        
        return cur.toString();
    }
}
