class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // Case 1: House 0 to n-2
        int ans1 = help(nums, 0, n - 2);

        // Case 2: House 1 to n-1
        int ans2 = help(nums, 1, n - 1);

        return Math.max(ans1, ans2);
    }

    // Isme wahi House Robber I ka O(1) space logic aayega!
    private int help(int[] nums, int start, int end) {
        int one = nums[start];
        int two = Math.max(one, nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int curr = Math.max(two, nums[i] + one);
            one = two;
            two = curr;
        }
        return two;
    }
}
