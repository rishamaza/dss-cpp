class Solution { 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Kahn's Algo
        // Step 1: Adjacency List aur Indegree array banao
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // [a, b] ka matlab: b -> a (pehle b, fir a)
        for (int[] req : prerequisites) {
            int course = req[0];
            int preq = req[1];
            adj.get(preq).add(course);
            indegree[course]++;
        }

        // Indegree 0 wale courses Queue me daalo
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int completed = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            completed++;

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--; // Ek kaam pura hua 
                if (indegree[neighbor] == 0) {
                    q.add(neighbor); // pura hone ke bad age badho 
                }
            }
        }
        // Agr courses completed ho gya
        return completed == numCourses;
    }
}
