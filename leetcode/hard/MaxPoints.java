package leetcode.hard;
import java.util.*;
public class MaxPoints {

	
	  
	  class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }
	 
	
    public int maxPoints(Point[] points) {
    	
    	if(points.length <= 2) return 2;
    	
    	int result = 0;
        for(int i=0; i<points.length; i++) {
        	int sameP = 0; int sameX = 1;
        	Map<Double, Integer> map = new HashMap<>();
        	for(int j=0; j<points.length; j++) {
          if(j!=i) {
        	if(points[i].x ==points[j].x  && points[j].y ==points[i].y) { 
        		sameP++;
        	}
        	if(points[i].x == points[j].x) {
        		sameX++;
        		continue;
        	}
        		Double slope = (double) ((points[j].y - points[i].y)/(points[j].x - points[i].x));
        		if(map.containsKey(slope)) {
        		map.put((slope), map.get(slope) + 1);
        		}
        		else {
        			map.put((slope), 2);
        		}
        		result = Math.max(result, map.get(slope) + sameP);
        	  }
        	}
        	result = Math.max(result, sameX);
          }
        	return result; 
        }
        

}
