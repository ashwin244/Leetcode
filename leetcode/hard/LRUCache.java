package leetcode.hard;
import java.util.*;
class Node {
	int key;
	int value;
	Node next;
	Node pre;
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {

	Map<Integer, Node> map = new HashMap<>();
	int capacity;
	Node head = null;
	Node end =  null;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public void remove(Node node) {
    	if(node.pre != null) {
    		node.pre.next = node.next;
    	}
    	else {
    		head = node.next;
    	}
    }
    
    public void setHead(Node node) {
    	node.next = head;
    	node.pre = null;
    	head = node;
    	
    	if(end == null) {
    		end = head;
    	}
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	Node n = map.get(key);
        	remove(n);
        	setHead(n);
        	return n.value;
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
        	Node old = map.get(key);
        	old.value = value;
        	remove(old);
        	setHead(old);
        }
        
        else {
        	Node create = new Node(key, value);
        	if(map.size() >= capacity) {
        		map.remove(end.key);
        		remove(end);
        		setHead(create);
        	} else {
        		setHead(create);
        	}
        	map.put(key, create);
        }
    }
}
