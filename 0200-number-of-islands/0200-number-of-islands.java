class Solution {
    // DFS && Not used visited list instead made the visited = '0'
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r == m || c < 0 || c == n || grid[r][c] == '0') {
            return;
        }
        // Current land node ko sink kar do (to avoid visiting again)
        grid[r][c] = '0';

        dfs(grid, r - 1, c); // Up
        dfs(grid, r + 1, c); // Down
        dfs(grid, r, c - 1); // Left
        dfs(grid, r, c + 1); // Right
    }
    /* BFS
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // 4 direction vectors (Up, Down, Left, Right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    
                    // Queue me coordinates store karne ke liye int[]{r, c}
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{r, c});
                    grid[r][c] = '0'; // Immediately mark as visited

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int currR = curr[0];
                        int currC = curr[1];

                        for (int[] dir : directions) {
                            int nr = currR + dir[0];
                            int nc = currC + dir[1];

                            // Out of bounds aur paani ('0') check
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0'; // Queue me daalte hi sink ('0') kar do!
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return islandCount;
    }
    */
}
