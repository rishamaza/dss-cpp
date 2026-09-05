/* Recursive
class Solution {
    public int rob(int[] nums) {
        return dfs(nums, 0);
    }
    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        return Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));
    }
}
*/
/* DP (Top-Down)
class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0);
    }
    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1)
            return dp[i];
        dp[i] = Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));

        return dp[i];
    }
}
*/
// DP (Bottom - Up)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int prev1 = 0; // House -1 (shuruat se pehle) tak ka answer (i - 2 state) dp[i - 2]
        int prev2 = nums[0]; // House 0 tak ka best answer (i - 1 state) dp[i - 1]

        for(int i = 1; i < n; i++){
            int pick = prev1 + nums[i];
            int nopick = prev2;

            int curr = Math.max(pick, nopick);

            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }
}