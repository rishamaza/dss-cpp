/*

// 2 CASES check krna h bas :
// Cycle check krna h since Tree dont have cycle
// Non conected graph ( 0 -- 1  2 -- 3) to uske ke liye:
//     Graph theory ka ek mast formula hai: n nodes wale tree me hamesha exactly (n - 1) edges hoti
// hain.

// DFS approach
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); // 0 -- 1
            adj.get(edge[1]).add(edge[0]); // 1 -- 0
        }

        Set<Integer> visited = new HashSet<>();
        dfs(0, adj, visited);

        // Agr cycle rhega to n tk jayega hi nhi
        return visited.size() == n;
    }

    private void dfs(int node, List<List<Integer>> adj, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
*/
class Solution {
    private int[] parent;

    public boolean validTree(int n, int[][] edges) {
        // STEP 1: Tree ki Golden Condition check karo
        // N nodes wale Tree me HAMESHA exact (N - 1) edges hoti hain.
        // Agar edges kam hain -> Graph disconnected hai.
        // Agar edges zyada hain -> Cycle pakka banegi.
        if (edges.length != n - 1) {
            return false;
        }

        // STEP 2: DSU Initialization
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Shuru me har node khud ka Ultimate Boss/Leader hai
        }

        // STEP 3: Har edge par DSU ka Magic Chalao
        for (int[] edge : edges) {
            int rootU = find(edge[0]); // Node U ka Ultimate Boss
            int rootV = find(edge[1]); // Node V ka Ultimate Boss

            // AGAR DONO KA ULTIMATE BOSS PEHLE SE SAME HAI:
            // Iska matlab U aur V pehle se kisi raste se jude hue the.
            // Ab inke beech nayi edge daalenge toh CYCLE ban jayegi!
            if (rootU == rootV) {
                return false; 
            }

            // UNION OPERATION: Dono Gangs ko merge kar do
            // Node U ke Ultimate Boss ko Node V ke Ultimate Boss ke under daal do
            parent[rootU] = rootV;
        }

        // Saari edges safely add ho gayi, koi cycle nahi mili -> Valid Tree!
        return true;
    }

    // FIND FUNCTION WITH PATH COMPRESSION (Shortcut Trick)
    private int find(int i) {
        // Base Case: Agar banda khud ka boss hai, matlab wahi Main Leader hai
        if (parent[i] == i) {
            return i;
        }

        // PATH COMPRESSION MAGIC:
        // 1. find(parent[i]) -> Recursively Ultimate Boss dhoond ke lata hai.
        // 2. parent[i] = ... -> Apne parent array me DIRECT Ultimate Boss ko set kar deta hai (Shortcut!).
        // 3. return ... -> Boss ka naam aage pass kar deta hai.
        return parent[i] = find(parent[i]);
    }
}
