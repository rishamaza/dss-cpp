class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
// Using QuickSelect algorithm (Lomuto/Hoare partition scheme), average time complexity is O(N) but mujhe nhi ata h ð¤«.
//Par code level implementation and space bound ke liye Min-Heap solution sabse clean aur production-ready hai.