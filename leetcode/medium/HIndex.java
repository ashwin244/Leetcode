package leetcode.medium;


public class HIndex {
	public static void main(String[] args)  {
		int[] a= {3, 0, 6, 1, 5};
		hIndex(a);
	}
    public static int hIndex(int[] citations) {
    	int[] bucket = new int[citations.length + 1];
    	
    	for(int c: citations) {
    		if(c > citations.length) {
    			bucket[citations.length]++;
    		}
    		else {
    			bucket[c]++;
    		}
    	}
        int hIndex = 0;
        int total = 0;
        for(int i=citations.length; i > 0; i--) {
        	total += bucket[i];
        	if(total>= i) {
        		hIndex = i;
        		break;
        	}
        }

        return hIndex;
    }
}
