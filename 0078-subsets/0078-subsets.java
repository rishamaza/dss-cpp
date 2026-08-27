class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), result, nums);
        return result;
    }
    private void backtrack(int start, List<Integer> path, List<List<Integer>> result, int[] nums) {
        result.add(new ArrayList(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i + 1, path, result, nums);
            path.remove(path.size() - 1);
        }
    }
    /*
    // Tree method if order doesn't matter 
    // Works on include exclude method using and dfs
    private void dfs(int index, int[] nums, List<Integer> path, List<List<Integer>> result) {
        // Base case: saare elements ke Yes/No decisions le liye
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Choice 1: INCLUDE (Element ko list mein daalo)
        path.add(nums[index]);
        dfs(index + 1, nums, path, result);

        // UNDO (Backtrack)
        path.remove(path.size() - 1);

        // Choice 2: EXCLUDE (Element ko chhod do)
        dfs(index + 1, nums, path, result);
    }
    */
}
