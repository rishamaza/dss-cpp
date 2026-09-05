/* Fibonacci recursion method
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);

        return left + right;
    }
}
*/
/* DP (Top - Bottom) # Memoization
class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return dfs(n, 0);
    }
    private int dfs(int n, int i) {
        if (i >= n)
            return i == n ? 1 : 0;

        if (dp[i] != -1)
            return dp[i];

        return dp[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}
*/
// DP (Bottom-Up) # Tabulation with optimized space
class Solution {
    public int climbStairs(int n) {
        int prev1 = 1, prev2 = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

