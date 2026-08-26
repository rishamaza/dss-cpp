class Solution {
    public int lastStoneWeight(int[] stones) {
        // khel ho rha h max element ya min ke sath to pq ka chance h
// max heap banan h bade stone nikalna h to desc me sort krna h 
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
// Collections.reverseOrder() ye kr skte the for desc sorting but i am thoda jada kabil
        for (int num : stones) {
            pq.add(num);
        }

        while (pq.size() > 1) {
            int first = pq.poll(); // first stone ðª¨
            int second = pq.poll();
            // left the case of first == second why??
            // because hmlog ne already pop kr diya h element aur zero add se koi fayda nhi h
            // because negative me stones nhi hote ð¤£
            if (first != second) {
                pq.add(first - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
