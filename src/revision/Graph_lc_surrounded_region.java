package revision;
//https://leetcode.com/problems/surrounded-regions/submissions/
public class Graph_lc_surrounded_region {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n =board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; ++j) {
                if (i == 0 || j == 0 || i == m-1 || j == n-1 ) {
                    if (board[i][j] == 'O') {
                        dfs(i, j, visited, board) ;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; ++j) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i, int j, boolean[][]visited, char[][]board) {
        if (i<0 || j<0 || i == board.length || j == board[0].length ||
                visited[i][j] || board[i][j] == 'X') {
            return;
        }
        visited[i][j] = true;
        dfs(i+1, j, visited, board);
        dfs(i-1, j, visited, board);
        dfs(i, j+1, visited, board);
        dfs(i, j-1, visited, board);
    }
}
