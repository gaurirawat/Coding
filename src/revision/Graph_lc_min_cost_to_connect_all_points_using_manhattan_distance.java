package revision;

import java.util.Arrays;

//https://leetcode.com/problems/min-cost-to-connect-all-points/
public class Graph_lc_min_cost_to_connect_all_points_using_manhattan_distance {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] set = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        int spanningDistance = 0;

        for (int i = 0; i < n; ++i) {
            int v = getMinDistance(distance, set);
            set[v] = true;
            spanningDistance += distance[v];
            updateDistance(v, points, distance, set);
        }

        return spanningDistance;
    }

    public int getMinDistance(int[] distance, boolean[]set) {
        int v = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; ++i) {
            if (!set[i] && minDistance > distance[i]) {
                minDistance = distance[i];
                v = i;
            }
        }
        return v;
    }
    public void updateDistance(int u, int[][]points, int[]distance, boolean[]set) {
        for (int v = 0; v <distance.length; ++v) {
            int newDistance = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
            if (!set[v] && distance[v] > newDistance) {
                distance[v] = newDistance;
            }
        }
    }
}
