class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), result, candidates, 0, target);
        return result;
    }

    private void backtrack(int start, List<Integer> path, List<List<Integer>> result, int[] nums, int sum, int target) {

        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        if (sum > target || start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {

// ye condition pahle use nhi hua kyunki whn unique element the 

// Sahi Comment:
// i > start ka matlab hai hum is tree depth par PEHLE option (i == start) ko check kar chuke hain.
// Agar agla option (i > start) bhi pichle option jaisa same number hai (nums[i] == nums[i-1]),
// toh duplicate combination banne se bachane ke liye isey SKIP (continue) karo.
 
            if (i > start && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);
            backtrack(i + 1, path, result, nums, sum + nums[i], target);
            path.remove(path.size() - 1);
        }
    }
}
