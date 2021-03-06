package leetcode.medium;

import java.util.Arrays;

/**
 * 
You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that 
amount. If that amount of money cannot be made up by any combination of the coins, 
return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.
 *
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(coins, Integer.MAX_VALUE); 
        for(int c: coins) {
        	for(int i=c; i<=amount; i++) {
        		if(dp[amount - i] != Integer.MAX_VALUE) {
        			dp[i] = Math.min(dp[i], dp[amount - i] + 1);
        		}
        	}
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
