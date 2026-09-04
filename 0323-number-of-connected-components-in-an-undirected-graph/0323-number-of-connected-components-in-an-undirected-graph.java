/*class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int res = 0;
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(adj, visited, node);
                // baat ye h ki dfs ya bfs me ek node se hi one go me sare node traversed ho jate hn
                // to isliye res check krega kitna bar krna pad rha rha utna hi different graphs
                // honge
                res++;
            }
        }
        return res;
    }
    private void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }
}*/

class Solution {
    private int[] parent;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int components = n;
        for (int[] edge : edges) {
            int rootU = find(edge[0]); // Master khojo aur lao
            int rootV = find(edge[1]); // Master khojo aur lao

            // Dono alag gang ke h to hmne merge kr diya
            if (rootU != rootV) {
                parent[rootU] = rootV; // merge kr rhe hn
                components--; // merge krne ke bad 1 hi bachega
                // ab agr edge hi nhi diya h do node iska mtlb wo sb non connected ho skte hn to
                // isliye components 1 ke equal nhi hoga aur result me no. of graphs a jayega
            }
        }
        return components;
    }
    private int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]); // Master khojo
    }
}
