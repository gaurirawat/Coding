package revision;
//https://leetcode.com/problems/paint-house/submissions/
public class DP_lc_paint_house {
    public int minCost(int[][] cost) {
        int n = cost.length;
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[] c = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            a[i] = cost[i - 1][0] + Math.min(b[i - 1], c[i - 1]);
            b[i] = cost[i - 1][1] + Math.min(a[i - 1], c[i - 1]);
            c[i] = cost[i - 1][2] + Math.min(a[i - 1], b[i - 1]);
        }
        return Math.min(a[n], Math.min(b[n], c[n]));
    }
}
