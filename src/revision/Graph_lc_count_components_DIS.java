package revision;
//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/submissions/
public class Graph_lc_count_components_DIS {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for (int i = 0; i < n; ++i) {
            root[i] = i;
        }

        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (!find(u, v, root)) {
                union(u, v, root);
            }
        }

        int components = 0;
        for (int i = 0; i < n; ++i) {
            if (root[i] == i) {
                components++;
            }
        }
        return components;
    }

    public boolean find(int u, int v, int[]root) {
        return getRoot(u, root) == getRoot(v, root);
    }

    public void union(int u, int v, int[] root) {
        int rootU = getRoot(u, root);
        root[rootU] = getRoot(v, root);
    }

    public int getRoot(int v, int[] root) {
        while (root[v] != v) {
            root[v] = root[root[v]];
            v = root[v];
        }
        return v;
    }
}
