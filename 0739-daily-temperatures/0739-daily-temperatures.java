class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Agar aaj ka temp purane kisi din se jyada garam hai, toh unka wait khatam karo!
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int indx = stack.pop();
                ans[indx] = i - indx;
            }
            // Aaj ke din ko stack mein push kar do (aage ke garmi ka wait karne ke liye)
            stack.push(i);
        }
        return ans;
    }
}
