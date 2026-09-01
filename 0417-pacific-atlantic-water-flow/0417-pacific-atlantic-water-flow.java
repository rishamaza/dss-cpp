class Solution {

    private int[][] grid;
    private int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        grid = heights;
        m = heights.length;
        n = heights[0].length; // Fixed: Column count from heights[0]

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // 1. Boundary calls
        for (int c = 0; c < n; c++) {
            dfs(0, c, pacific, grid[0][c]);
            dfs(m - 1, c, atlantic, grid[m - 1][c]);
        }
        for (int r = 0; r < m; r++) {
            dfs(r, 0, pacific, grid[r][0]);
            dfs(r, n - 1, atlantic, grid[r][n - 1]);
        }

        // 2. Collect intersection
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) { // Fixed: c++ instead of r++
                if (pacific[r][c] && atlantic[r][c]) { // Fixed: && operator
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || grid[r][c] < prevHeight) {
            return;
        }
        visited[r][c] = true;

        dfs(r + 1, c, visited, grid[r][c]);
        dfs(r - 1, c, visited, grid[r][c]);
        dfs(r, c + 1, visited, grid[r][c]);
        dfs(r, c - 1, visited, grid[r][c]);
    }
}