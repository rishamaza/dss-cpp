/* Recursion Method
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }
    private int dfs(int[] cost, int i) {
        if (i >= cost.length)
            return 0;

        int left = cost[i] + dfs(cost, i + 1);
        int right = cost[i] + dfs(cost, i + 2);

        return Math.min(left, right);
    }
}
*/
/* DP (Top - Down)
class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }
    private int dfs(int[] cost, int i) {
        if (i >= cost.length)
            return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int left = cost[i] + dfs(cost, i + 1);
        int right = cost[i] + dfs(cost, i + 2);

        dp[i] = Math.min(left, right);

        return dp[i];
    }
}
*/
/* DP (Bottom - Up)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++){
            dp[i] = cost[i]+ Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}
*/
// DP (Bottom - Up) Space optimized
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prev1 = cost[0];
        int prev2 = cost[1];

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev1 = prev2;
            prev2 = curr;
        }
        return Math.min(prev1, prev2);
    }
}
