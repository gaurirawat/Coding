package revision;
//Ref: https://www.geeksforgeeks.org/kth-ancestor-of-a-node-in-an-n-ary-tree-using-binary-lifting-technique/
//https://leetcode.com/problems/kth-ancestor-of-a-tree-node/submissions/
public class DP_Tree_lc_binary_lifting_find_kth_ancestor {
    class TreeAncestor {
        int dp[][];
        int maxPow;
        int n;

        public TreeAncestor(int N, int[] parent) {
            n = N;
            maxPow = (int) (Math.log(n) / Math.log(2)) + 1;
            dp = new int[maxPow][n];
            dp[0] = parent;
            for (int i = 1; i < maxPow; ++i) {
                for (int j = 0; j < n; ++j) {
                    int powMinusOneNode = dp[i - 1][j];
                    dp[i][j] = powMinusOneNode == -1 ? -1 : dp[i - 1][powMinusOneNode];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            int maxPow = this.maxPow;
            while (k > 0 && node != -1) {
                if (k >= (1 << maxPow)) {
                    node = dp[maxPow][node];
                    k -= (1 << maxPow);
                }
                maxPow--;
            }
            return node;
        }
    }
}