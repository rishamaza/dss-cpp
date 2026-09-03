/* Kahn's Algorithm (In-degree BFS) ka ek hi solid principle hai: Queue me sirf wahi course enter
 * kar sakta hai jiska in-degree 0 ho chuka hoâyaani jiske saare prerequisites complete ho chuke
 * hain.
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int req = pre[1];
            adj.get(req).add(course); // req -> course
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            result[idx++] = curr;

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        return idx == numCourses ? result : new int[0];
    }
}
