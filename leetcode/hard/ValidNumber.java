package leetcode.hard;

public class ValidNumber {

	public static void main(String[] args) {

	}

    public boolean isNumber(String s) {
    	s = s.trim();
    	boolean numberSeen = false,  pointSeen = false,  
    			numberAfterE = false, eSeen = false;
    	
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
    			numberSeen = true;
    			numberAfterE = true;
    		}
    		
    		else if(s.charAt(i) == '.') {
    			if(eSeen || pointSeen) {
    				return false;
    			}
    			pointSeen = true;
    		}
    		
    		else if(s.charAt(i) == 'e') {
    			if(!numberSeen || eSeen) {
    				return false;
    			}
    			eSeen = true;
    			numberAfterE = false;
    		}
    		
    		else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
    			if(i!= 0 && s.charAt(i-1) != 'e') {
    				return false;
    			}
    		}
    		
    		else {
    			return false;
    		}
    	}
		return numberSeen && numberAfterE; 
    }
    
}
