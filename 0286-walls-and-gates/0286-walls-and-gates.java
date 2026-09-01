/*
 * LOGIC CHEAT CODE (Multi-Source BFS):
 * 1. MULTI-SOURCE START: Saare Treasures (0) ko ek saath Queue mein daalo (Ye Wave Level 0 hai).
 * 2. DISTANCE WAVE: BFS se charo taraf phailo -> Agar neighbor INF hai, toh grid[nr][nc] = grid[r][c] + 1 karke usko Queue mein push karo.
 */

class Solution {
    // Shortest Path use BFS, DFS will fail 💀
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    q.add(new int[] {row, col});
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == Integer.MAX_VALUE) {
                    grid[nr][nc] = grid[r][c] + 1;
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}
