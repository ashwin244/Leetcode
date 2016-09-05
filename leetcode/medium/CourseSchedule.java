package leetcode.medium;
import java.util.*;
public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	int[] incomingLinkPerNode = new int[numCourses];
    	List<List<Integer>> adjacentCourses = new ArrayList<>();
    	intializeGraph(incomingLinkPerNode, adjacentCourses, prerequisites);
    	return courseOrder(incomingLinkPerNode, adjacentCourses);
    }
    
    public void intializeGraph(int[] incomingLinkPerNode, List<List<Integer>> adjacentCourses, int[][] prerequisites) {
    	int n = incomingLinkPerNode.length;
    	while(n-- > 0) {
    		adjacentCourses.add(new ArrayList<Integer>());
    	}
    	for(int[] p : prerequisites) {
    		incomingLinkPerNode[p[0]]++;
    		adjacentCourses.get(p[1]).add(p[0]);
    	}
    }
    
    
    public int[] courseOrder(int[] incomingLinkPerNode, List<List<Integer>> adjacentCourses) {
    	int n = incomingLinkPerNode.length;
    	int[] order = new int[n];
    	
    	Queue<Integer> q = new ArrayDeque<>();
    	for(int i=0; i<n; i++) {
    		if(incomingLinkPerNode[i]==0) {
    			q.offer(i);
    		}
    	}
    	int i=0;
    	while(!q.isEmpty()) {
    		Integer poll = q.poll();
    		order[i++] = poll;
    		
    		for(int a: adjacentCourses.get(poll)) {
    			incomingLinkPerNode[a]--;
    			if(incomingLinkPerNode[a] == 0) {
    				q.offer(a); 
    			}
    		}
    	}
    	return i==n ? order : new int[0];
    }
    
}
