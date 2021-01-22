package revision;
//Ref: https://www.geeksforgeeks.org/kth-ancestor-of-a-node-in-an-n-ary-tree-using-binary-lifting-technique/
//https://leetcode.com/problems/kth-ancestor-of-a-tree-node/submissions/

/*
Ref:
https://www.geeksforgeeks.org/kth-ancestor-of-a-node-in-an-n-ary-tree-using-binary-lifting-technique/
https://www.youtube.com/watch?v=ctZ7fjMbPWE&ab_channel=GauravSen

Approach:
This is a technique where we pre-compute parent of every node which are at a distance of 1, 2, 4, 8, 16 ..upto log(n);
Now if n=5, maxPow=log(5)=2 and the tree is skewed, we need parent at distance 1, 2, 4.
Therefore size becomes dp[maxPow+1][n];

DP:
State of dp is dp[i][j]= parent of jth node at a distance of 2^i. ie i= ith-power in 2^i, j= jth node.
Recursive equation:
    parent of jth node at height h= parent of (parent of ith node at height h/2)th node at height h/2
    in terms of height: dp[height h][j]= dp[ height h/2 ][ dp[height h/2][j]]
    final recursive eqn in terms of ith power:
        dp[i][j]= dp[i-1][ dp[i-1][j] ]

Once we pre-compute this matrix dp, the kth ancestor can be found in O(logN).
1. For each query of k and node we find the max i where 2^i<=k. ie we go to the pre computed parent at max distance
possible.
    node=dp[maxPow][node];
    k-=(1<<maxPow);
Update k=k-2^i. ie to the remaining distance.
2. Now repeat step 1 for the new value of k until k=0 or if the node=-1.

 */
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

    /*
    int[][] dp;
    public TreeAncestor(int n, int[] parent) {
        int ht = (int)(1.0 * Math.log(n) / Math.log(2));
        dp = new int[ht + 1][n];
        dp[0] = parent;
        for (int i =1; i <= ht; ++i) {
            for (int j = 0; j < n; ++j) {
                if(dp[i - 1][j] == -1) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = dp[i - 1][dp[i - 1][j]];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        while (k != 0 && node != -1) {
            int ht = (int)(1.0 * Math.log(k) / Math.log(2));
            k -= Math.pow(2, ht);
            node = dp[ht][node];
        }
        return node;
    }
     */
}