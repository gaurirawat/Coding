package revision;

import java.util.*;
//https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/submissions/
public class Graph_lc_shortest_path_with_obstacles_elimination {
    public int shortestPath(int[][] grid, int k) {
        if (k == 0 && grid[0][0] == 1) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][grid[0][0]] = true;

        PriorityQueue<Cell> pq = new PriorityQueue<Cell>((a, b) ->(a.path - b.path));
        pq.add(new Cell(0, 0, grid[0][0], 0));
        while(!pq.isEmpty()) {
            Cell cell = pq.poll();
            if (cell.i == m - 1 && cell.j == n - 1) {
                return cell.path;
            }

            for (int[] arr : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                int newi = cell.i +arr[0];
                int newj = cell.j +arr[1];

                if (newi >= 0 && newj >= 0 && newi < m && newj < n) {
                    int newk = cell.k + grid[newi][newj];
                    if (newk <= k && !visited[newi][newj][newk]) {
                        visited[newi][newj][newk] = true;
                        pq.add(new Cell(newi, newj, newk, cell.path + 1));
                    }
                }
            }
        }
        return -1;
    }

    class Cell{
        int i;
        int j;
        int k;
        int path;

        public Cell(int a, int b, int c, int d) {
            i = a;
            j = b;
            k = c;
            path = d;
        }
    }
}
