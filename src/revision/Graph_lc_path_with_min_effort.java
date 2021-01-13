package revision;

import java.util.*;
//https://leetcode.com/problems/path-with-minimum-effort/
public class Graph_lc_path_with_min_effort {
    public int minimumEffortPath(int[][] ht) {
        if (ht.length == 0) {
            return 0;
        }

        int m = ht.length;
        int n = ht[0].length;
        int[][] maxEffort = new int[m][n];
        for (int[] arr : maxEffort) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<Coordinate> pq = new PriorityQueue<Coordinate>
                (Comparator.comparingInt(a-> a.effort));
        maxEffort[0][0] = 0;
        pq.add(new Coordinate(0, 0, 0));

        while (!pq.isEmpty()) {
            Coordinate c = pq.poll();
            if (c.i == m - 1 && c.j == n - 1) {
                return c.effort;
            }

            for (int[] dxy : new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}} ) {
                int i = c.i + dxy[0];
                int j = c.j + dxy[1];

                if (i >= 0 && j >= 0 && i < m && j < n) {
                    int dev = Math.abs(ht[i][j] - ht[c.i][c.j]);
                    int effort = Math.max(dev, c.effort);
                    if (effort < maxEffort[i][j]) {
                        maxEffort[i][j] = effort;
                        pq.add(new Coordinate(i, j, effort));
                    }
                }
            }
        }
        return -1;
    }
    class Coordinate{
        int i;
        int j;
        int effort;
        public Coordinate(int a, int b, int c) {
            i = a;
            j = b;
            effort = c;
        }
    }
}