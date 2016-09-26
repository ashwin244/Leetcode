package leetcode.medium;
import java.util.*;
public class QueueUsingStacks {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        if(stack1.isEmpty()) {
        	stack1.push(x);
        }
        
        else {
        	while(!stack1.empty())
        		stack2.push(stack1.pop());
        	
        	stack1.push(x);
        	while(!stack2.empty())
        		stack1.push(stack2.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack1.pop();
    }

    // Get the front element.
    public int peek() {
        return stack1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	return stack1.isEmpty() && stack2.isEmpty();
    }
}
