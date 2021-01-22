package revision;

import java.util.Arrays;

//https://leetcode.com/problems/path-with-maximum-probability/submissions/
public class Graph_lc_path_with_max_prob_dijkstra {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] prob = new double[n];
        boolean[] set = new boolean[n];
        Arrays.fill(prob, 0);
        prob[start] = 1.0;

        for (int i = 0; i < n; ++i) {
            int v = getMaxProbVertex(prob, set);
            if (end == v) {
                return prob[v];
            } else if (v == -1) {
                return 0.0;
            }
            set[v] = true;
            updateProbabilities(v, prob, edges, succProb);
        }
        return 0.0;
    }

    public void updateProbabilities(int u, double[] prob, int[][] edges, double[] succProb) {
        for (int i = 0; i <edges.length; ++i) {
            if (edges[i][0] == u) {
                int v = edges[i][1];
                double p = succProb[i];
                if (prob[v] < prob[u] * p) {
                    prob[v] = prob[u] * p;
                }
            } else if (edges[i][1] == u) {
                int v = edges[i][0];
                double p = succProb[i];
                if (prob[v] < prob[u] * p) {
                    prob[v] = prob[u] * p;
                }
            }
        }
    }

    public int getMaxProbVertex(double[] prob, boolean[] set) {
        int v = -1;
        double max = 0;
        for (int i = 0; i < prob.length; ++i) {
            if(!set[i] && max < prob[i]) {
                max = prob[i];
                v = i;
            }
        }
        return v;
    }
}
