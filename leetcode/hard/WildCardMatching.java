package leetcode.hard;

public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        int sLength = 0, pLength = 0, match = 0, index = -1;
        
        while(sLength < s.length()) {
        	if(pLength < p.length() && (p.charAt(pLength) == '?') || (p.charAt(pLength) == s.charAt(sLength))) {
        		sLength++;
        		pLength++;
        	}
        	
        	else if(pLength < p.length() && p.charAt(pLength) == '*') {
        		index = pLength; //index only changes when we have '*'
        		match = sLength;
        		pLength++;
        	}
        	
        	else if(index != -1) {
        		pLength = index + 1; 
        		match++;
        		sLength = match;
        	}
        	
        	else 
        		return false;
        }
        
        while (pLength < p.length() && p.charAt(pLength) == '*') {
        	pLength ++;
        }
        
        return pLength == p.length();
    }
}
