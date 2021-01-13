package revision;
//https://leetcode.com/problems/max-area-of-island/submissions/
public class Graph_lc_max_area_of_island {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        boolean[][]visited = new boolean[m][n];
        int c = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    c = Math.max(c, dfs(i, j, visited, grid));
                }
            }
        }
        return c;
    }

    public int dfs(int i, int j, boolean[][]visited, int[][]grid) {
        if (i < 0 || j < 0 || i == visited.length || j == visited[0].length || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        int c = 1;
        visited[i][j] = true;
        c += dfs(i + 1, j, visited, grid);
        c += dfs(i - 1, j, visited, grid);
        c += dfs(i, j + 1, visited, grid);
        c += dfs(i, j - 1, visited, grid);
        return c;
    }
}
