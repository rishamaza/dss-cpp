class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int next = 0;
        while (slow != next) {
            slow = nums[slow];
            next = nums[next];
        }
        return slow;
    }
}
