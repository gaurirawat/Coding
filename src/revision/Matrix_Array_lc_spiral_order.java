package revision;

import java.util.*;

//https://leetcode.com/problems/spiral-matrix/submissions/
public class Matrix_Array_lc_spiral_order {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        int midR = m/2 + (m % 2 == 0 ? 0 : 1);
        int midC = n/2 + (n % 2 == 0 ? 0 : 1);
        int k = 0;

        while (list.size() < m*n) {
            if (k < midR && k < midC) {
                for (int j = k; j < n - k; ++j) {
                    list.add(matrix[k][j]);
                }
                for (int i = k + 1; i < m - k; ++i) {
                    list.add(matrix[i][n - k - 1]);
                }
            }

            if (m - k - 1 >= midR && n - k - 1 >= midC) {
                for (int j = n - k - 2; j >= k; --j) {
                    list.add(matrix[m - k - 1][j]);
                }
                for (int i = m - k - 2; i > k; --i) {
                    list.add(matrix[i][k]);
                }
            }
            k++;
        }

        return list;
    }
}
