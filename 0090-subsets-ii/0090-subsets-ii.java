class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, result, new ArrayList<>());
        return result;
    }
    private void backtrack(int start, int[] nums, List<List<Integer>> result, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(i + 1, nums, result, path);
            path.remove(path.size() - 1);
        }
    }
}
