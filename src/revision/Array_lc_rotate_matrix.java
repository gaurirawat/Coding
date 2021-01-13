package revision;
//https://leetcode.com/problems/rotate-image/submissions
public class Array_lc_rotate_matrix {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < i; ++j) {
                swap(matrix, i, j, j, i);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n/2; ++j) {
                swap(matrix, i, j, i, n - j - 1);
            }
        }
    }

    public void swap(int[][]matrix, int i, int j, int ii, int jj) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[ii][jj];
        matrix[ii][jj] = t;
    }
}
