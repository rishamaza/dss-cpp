class Solution {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int bossofU = find(u); 
            int bossofV = find(v);

            // Agr final boss h to -> cycle detected
            // yehi edge h hamara answer
            if(bossofU == bossofV){
                return edge;
            }

            // Union operation: Merge both components
            parent[bossofU] = bossofV;
        }

        return new int[0];
    }
    private int find(int i){
        if(i == parent[i]) return parent[i];
        return parent[i] = find(parent[i]);
    }
}
