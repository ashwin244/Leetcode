package leetcode.medium;
import java.util.*;
class Store {
	int val;
	int freq;
	Store(int val, int freq) {
		this.val = val;
		this.freq = freq;
	}
}
public class TopKFrequentElements {
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	PriorityQueue<Store> queue = new PriorityQueue<>(10, new Comparator<Store>() {
		@Override
		public int compare(Store p1, Store p2) {
			return p2.freq - p1.freq;
		}
	});
    public List<Integer> topKFrequent(int[] nums, int k) {
        for(int n: nums) {
        	queue.add(new Store(n, ))
        	
        }
    }
}
