package leetcode.medium;

/*
 * Given a string containing only digits, restore it by returning all 
 * possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
import java.util.*;
public class RestoreIPAddresses {

	public static void main(String[] args) {
		restoreIpAddresses("25525511135");
	}
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        populate(result, s, 0, "", 0);
        return result;
    }
    
    public static void populate(List<String> result, String s, int index, String address, int count) {
    	if(count > 4) {
    		return;
    	}
    	if(count == 4 && index == s.length())  {
    		result.add(address);
    	}
    	
    	for(int i=1 ; i<4; i++) {
    		if(index + i > s.length()) {
    			break;
    		}	
    		String sub = s.substring(index, index + i);
    		if((sub.startsWith("0") && sub.length() > 1) || Integer.parseInt(sub) >= 256) {
    			continue;
    		}
    		populate(result, s, index + i, address + sub + (count==3 ? "" : "."),count + 1);
    	}
    }
}
