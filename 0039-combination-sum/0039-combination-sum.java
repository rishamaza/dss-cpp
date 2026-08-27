class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), result, nums, 0, target);
        return result;
    }
    private void backtrack(int start, List<Integer> path, List<List<Integer>> result, int[] nums,
        int sum, int target) {
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i, path, result, nums, sum + nums[i], target);
            path.remove(path.size() - 1);
        }
    }
}
