package IB;

//https://www.interviewbit.com/problems/maximum-size-square-sub-matrix/
public class Matrix_DP_max_area_of_binary_square_sub_matrix {
    public int solve(int[][] a) {
        int max = 0;
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a[0].length; ++j) {
                if (i == 0 || j == 0) {
                    max = Math.max(a[i][j], max);
                    continue;
                }
                if (a[i][j] == 1) {
                    a[i][j] = 1 + Math.min(a[i - 1][j - 1], Math.min(a[i - 1][j], a[i][j - 1]));
                    max = Math.max(a[i][j] * a[i][j], max);
                }
            }
        }
        return max;
    }
}