package revision;

import java.util.*;

//https://leetcode.com/problems/critical-connections-in-a-network/submissions/
public class Graph_lc_critical_connections_in_a_graph {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < connections.size(); ++i) {
            int u =connections.get(i).get(0);
            int v =connections.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<List<Integer>> bridges = new ArrayList<List<Integer>>();
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];

        Integer time = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                findBridges(i, -1, time, disc, low, visited, bridges, graph);
            }
        }

        return bridges;
    }

    public void findBridges(int u, int parent, int time, int[] disc, int[] low, boolean[] visited, List<List<Integer>> bridges, List<List<Integer>> graph) {
        disc[u] = time;
        low[u] = time++;
        visited[u] = true;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                findBridges(v, u,  time, disc, low, visited, bridges, graph);
                low[u] = Math.min(low[u], low[v]);
                if (disc[u] < low[v]) {
                    addBridge(u, v, bridges);
                }
            } else if (v != parent){
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public void addBridge(int u, int v, List<List<Integer>> bridges) {
        ArrayList<Integer> edge = new ArrayList<Integer>();
        edge.add(u);
        edge.add(v);
        bridges.add(edge);
    }
}
