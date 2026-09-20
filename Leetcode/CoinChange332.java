// Minimum Coin Change / Bottom-Up DP (filename retains its historical label).
// Time: O(A*(C+1)); Memory: O(A+1), A=amount, C=denomination count.
// Pseudocode: seed dp[0], scan subtotals, minimize over reachable predecessor coins.
// Requires nonnegative amount and positive coins. See docs/ALGORITHM_GUIDE.md.

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // Represents impossible state
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0; // Base case
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] == max ? -1 : dp[amount];
    }
}
