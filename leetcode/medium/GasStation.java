package leetcode.medium;

/**
 * 
There are N gas stations along a circular route, where the amount of gas at
 station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to 
travel from station i to its next station (i+1). You begin the journey with an
 empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit 
once, otherwise return -1.
 *
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
	        int sumRemaining  = 0, total = 0; int current = 0;
	        int start = 0;
	        if(gas.length != cost.length) {
	        	return -1;
	        }
	        for(int i=0; i<gas.length; i++) {
	        	current = gas[i]-cost[i];
	        	
	        	if(sumRemaining >= 0) {
	        		sumRemaining += current;
	        	}
	        	
	        	else {
	        		sumRemaining = current;
	        		start = i;
	        	}
	        	
	        	total += current;
	        }
	        
	        if(total >= 0) {
	        	return start;
	        }
	        	return -1;
    }
}
