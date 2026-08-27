class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(visited, new ArrayList<>(), result, nums);
        return result;
    }

    private void backtrack(
        boolean[] visited, List<Integer> path, List<List<Integer>> result, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;

            path.add(nums[i]);
            visited[i] = true;

            backtrack(visited, path, result, nums);
            
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
