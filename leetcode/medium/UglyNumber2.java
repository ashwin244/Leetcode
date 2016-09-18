package leetcode.medium;

/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
 */
import java.util.*;
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        if(n==1) {
        	return 1;
        }
        
        PriorityQueue<Long> p = new PriorityQueue<>();
        p.add(1l);
        for(int i=0; i<n; i++) {
        	long temp = p.poll();
        	
        	while(!p.isEmpty() && temp == p.peek()) {
        		temp = p.poll();
        	}
        	
        	p.add(2*temp);
        	p.add(3*temp);
        	p.add(5*temp);
        }
        
        return p.peek().intValue();
    }
}
