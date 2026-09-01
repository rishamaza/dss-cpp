/*
 * ROTTING ORANGES CHEAT CODE (Multi-Source BFS):
 * 1. MULTI-SOURCE START: Saare Rotten Oranges (2) ko Queue me daalo aur Fresh Oranges (1) ko count karo.
 * 2. MINUTE WAVE (Level BFS): Queue ke Current Level Size par loop chalao -> 4 directions me Fresh (1) mile toh usko Rotten (2) banao, fresh-- karo aur Queue me daalo.
 * 3. RESULT: Agar fresh == 0 toh (time - 1) ya time return karo, varna -1 (sabhi tak sadand nahi pahunchi).
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0; // will keep data of fresh fruit

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 2) {
                    q.add(new int[] {row, col});
                }
                if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int min = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (fresh > 0 && !q.isEmpty()) {
            // minute count krna h ki 1 minute me kitna fruit sadega to for loop use krenge taki i
            // ek iteration rotten fruit ke ass pass wale hi sade
            int level = q.size();
            for (int i = 0; i < level; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n
                        && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            // ye loop 1 bar khtm hua to 1 minute hua to minute++
            min++;
        }
        // koi Fresh Orange chhoot toh nahi gaya
        return fresh == 0 ? min : -1;
    }
}
