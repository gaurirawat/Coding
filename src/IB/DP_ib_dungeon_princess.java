package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/dungeon-princess/

public class DP_ib_dungeon_princess {
    public int calculateMinimumHP(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        if (m == 0) {
            return 0;
        }
        if (a[m - 1][n - 1] > 0) {
            a[m - 1][n - 1] = 0;
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {

                if (!(i + 1 == m && j + 1 == n)) {
                    int right = j + 1 == n ? Integer.MIN_VALUE : a[i][j + 1];
                    int bottom = i + 1 == m ? Integer.MIN_VALUE : a[i + 1][j];
                    int max = Math.max(right, bottom);
                    a[i][j] += max;
                    if (a[i][j] > 0) {
                        a[i][j] = 0;
                    }
                }
            }
        }
        return Math.abs(a[0][0]) + 1;
    }
}
