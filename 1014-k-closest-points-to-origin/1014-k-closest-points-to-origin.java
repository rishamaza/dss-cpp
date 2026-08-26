/*
Gyan:
K Smallest chahiye?
Oppose karo -> Max-Heap use karo.
K Largest chahiye?
Oppose karo -> Min-Heap use karo.

// logic why ?? agr small no. ka list chahiye k size ka to max heap me se suruat me hatate rhenge tb
tk jb tk k element n bache kyunki wo sb maxheap ke pahle element se chote rhenge large no. to hmne
phek diya ð®

becuase it makes TC from O(NlogN) to O(Nlog(k)) ð
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Custom sort ð
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> {
            // distances A and B
            int distanceA = a[0] * a[0] + a[1] * a[1];
            int distanceB = b[0] * b[0] + b[1] * b[1];

            return distanceB - distanceA;
        });
        for (int[] p : points) {
            heap.add(p);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[][] result = new int[k][2];
        int idx = 0;

        while (!heap.isEmpty()) {
            result[idx++] = heap.poll();
        }
        return result;
    }
}
