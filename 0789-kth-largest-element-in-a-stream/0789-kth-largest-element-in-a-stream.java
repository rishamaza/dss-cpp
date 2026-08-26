class KthLargest {

    private Queue<Integer> heap; // min heap
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if(heap.size() > k){
            heap.poll();
        }
        return heap.peek();
    }
}
// Time Complexity: O(log K) per add() operation.
// Space Complexiy: O(k) extra space.