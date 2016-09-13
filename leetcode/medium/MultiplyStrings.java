package leetcode.medium;

/**
 * 
Given two numbers represented as strings, return multiplication of the 
numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
 *
 */
public class MultiplyStrings {
	
	public static void main(String[] args) {
		System.out.println(multiply("23", "45")); 
	}
    public static String multiply(String num1, String num2) {
        StringBuilder builder =  new StringBuilder();
        int[] pos = new int[num1.length() + num2.length()];	
        for(int i = num1.length()-1; i >= 0; i--) {
            for(int j = num2.length()-1; j >= 0; j--) {
            	int p1 = i+j, p2 = i+j+1;
            	int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + pos[p2];
            	pos[p1] += mul/10;
            	pos[p2] = mul%10;
            }
        }
        
        for(int i: pos) {
        	if(builder.length()==0 && i==0) continue;
        	builder.append(i);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
