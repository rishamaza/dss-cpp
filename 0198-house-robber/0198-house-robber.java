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

        int one = nums[0];
        int two = Math.max(nums[1], one);

        for(int i = 2; i < n; i++){
            int curr = Math.max(two, nums[i] + one);
            one = two;
            two = curr;
        }
        return two;
    }
}