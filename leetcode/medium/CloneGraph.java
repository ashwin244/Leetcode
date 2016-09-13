package leetcode.medium;
import java.util.*;

 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
public class CloneGraph {
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) {
    		return node;
    	}
        if(map.containsKey(node.label)) {
        	return map.get(node.label);
        }
        
        	UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        	map.put(clone.label, clone);
        	for(UndirectedGraphNode n: node.neighbors) {
        		clone.neighbors.add(cloneGraph(n)); 
        }
        return clone;
    }
}
