package revision;

import java.util.ArrayList;

//https://leetcode.com/problems/course-schedule/
public class Graph_lc_course_schedule {
    public boolean canFinish(int n, int[][] preReq) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<Integer>());
        }
        for (int[] edge : preReq) {
            g.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];
        boolean[] stack = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (!visited[i] && dfsCycleDetection(i, g, visited, stack)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfsCycleDetection(int u, ArrayList<ArrayList<Integer>> g ,
                                     boolean[]visited, boolean[]stack) {
        if (stack[u]) {
            return true;
        }
        if (visited[u]) {
            return false;
        }
        visited[u] = true;
        stack[u] = true;
        for(int v: g.get(u)) {
            if (dfsCycleDetection(v, g, visited, stack)) {
                return true;
            }
        }
        stack[u] = false;
        return false;
    }
}
