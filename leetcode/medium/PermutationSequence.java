package leetcode.medium;

/**
 * 
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
 *
 */
import java.util.*;
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        List<Integer> num = new ArrayList<>();
        for(int i=1; i<=n; i++) {
        	num.add(i);
        }
        fact[0]  = 1;
        for(int i = 1; i<n; i++) {
        	fact[i] = i*fact[i-1];
        }
        
        k = k-1;
        
        StringBuilder s = new StringBuilder();
        for(int i = n; i>0; i--) {
        	int index = k / fact[i-1];
        	k = k%fact[i-1];
        	s.append(num.get(index));
        	num.remove(index);
        }
        
        return s.toString();
    }
}
