package revision;
//https://leetcode.com/problems/knight-probability-in-chessboard/

public class DP_lc_knight_probability {
    public double knightProbability(int n, int K, int r, int c) {
        int[][] movements = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        double prob[][] = new double[n][n];
        prob[r][c] = 1.0;

        for (int k = 0; k < K; ++k) {
            double[][] newProb = new double[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int[] arr : movements) {
                        int newi = i + arr[0];
                        int newj = j + arr[1];

                        if (newi >= 0 && newj >= 0 && newi < n && newj < n) {
                            newProb[newi][newj] += prob[i][j] / 8.0;
                        }
                    }
                }
            }
            prob = newProb;
        }

        double totalProb = 0.0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                totalProb += prob[i][j];
            }
        }
        return totalProb;
    }
}
