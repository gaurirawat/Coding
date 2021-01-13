package revision;
//https://leetcode.com/problems/number-of-closed-islands/submissions/
public class Graph_lc_count_islands {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            dfs(i, 0, visited, grid);
            dfs(i, n - 1, visited, grid);
        }
        for (int j = 0; j < n; ++j) {
            dfs(0, j, visited, grid);
            dfs(m - 1, j, visited, grid);
        }

        int c = 0;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    dfs(i, j, visited, grid);
                    c++;
                    // System.out.println(i + " " + j);
                }
            }
        }
        return c;
    }

    public void dfs(int i, int j, boolean[][]visited, int[][]grid) {
        if (i < 0 || j < 0 || i == visited.length || j == visited[0].length || grid[i][j] == 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, visited, grid);
        dfs(i - 1, j, visited, grid);
        dfs(i, j + 1, visited, grid);
        dfs(i, j - 1, visited, grid);
    }
}
