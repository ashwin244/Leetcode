package leetcode.medium;

/**
 * 
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */
import java.util.*;
public class ReversePolish {
	public static void main(String[] args) {
		String[] str = {"2", "1", "+", "3", "*"};
		evalRPN(str);
	}
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String operators = "+-/*";
        for(String s: tokens) {
        	if(operators.contains(s)) {
        		int a = stack.pop();
        		int b = stack.pop();
        		switch(s) {
        		case "+" : stack.push(a + b);
        			break;
        		case "-" : stack.push(b - a);
        			break;
        		case "/" : stack.push(b / a);
        			break;
        		case "*" : stack.push(a * b);
        			break;
        		}
        	}
        	else {
        		stack.push(Integer.parseInt(s));
        	}
        }
        
        return stack.isEmpty() ? 0 : stack.pop();
    }
}
