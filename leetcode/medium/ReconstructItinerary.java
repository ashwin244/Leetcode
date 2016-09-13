package leetcode.medium;

/**
 * 
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. 
All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. 
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 *
 */
import java.util.*;
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
    	List<String> result = new ArrayList<>();
    	if(tickets == null || tickets.length == 0) {
    		return result;
    	}
    	Map<String, PriorityQueue<String>> map = new HashMap<>();
    	for(int i=0; i<tickets.length; i++) {
    		if(!map.containsKey(tickets[i][0])) {
    			map.put(tickets[i][0], new PriorityQueue<String>());
    		}
    		map.get(tickets[i][0]).add(tickets[i][1]);
    	}
    	
    	String curr = "JFK";
    	Stack<String> back = new Stack<>();
    	for(int i=0; i<tickets.length; i++) {
    		while(!map.containsKey(curr) || map.get(curr).isEmpty()) {
    			back.push(curr);
    			curr = result.remove(result.size()-1);
    		}
    		result.add(curr);
    		curr = map.get(curr).poll();
    	}
    	result.add(curr);
    	while(!back.isEmpty()) {
    		result.add(back.pop());
    	}
    	
    	
    	return result;
    	
    }
}
