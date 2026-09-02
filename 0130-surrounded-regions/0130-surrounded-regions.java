class Solution {
    private int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        // Boundary wale zero to nhi honge cover so unlog ko pakad kr dfs mar do aur T mark krdo baki bache O ko X aur jo T kiye unko wapas se O kr denge finally 

        // Upr and niche 
        for(int c = 0; c < n; c++){
            if(board[0][c] == 'O'){
                dfs(board, 0, c);
            }
            if(board[m - 1][c] == 'O'){
                dfs(board, m - 1, c);
            }

        }

        // Left and Right
        for(int r = 0; r < m; r++){
            if(board[r][0] == 'O'){
                dfs(board, r, 0);
            }
            if(board[r][n - 1] == 'O'){
                dfs(board, r, n - 1);
            }

        }

        // Grid convert
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(board[row][col] == 'O'){
                    board[row][col] = 'X';
                }else if(board[row][col] == 'T'){
                    board[row][col] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int r, int c){
        if(r < 0 || r == m || c < 0 || c == n || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
