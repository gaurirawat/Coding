package IB;

import java.util.Arrays;
//https://www.interviewbit.com/problems/matrix-median/
public class BSearch_ib_matrix_median {
    public int findMedian(int[][] a) {
        if (a.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; ++i) {
            min = Math.min(min, a[i][0]);
            max = Math.max(max, a[i][a[0].length - 1]);
        }
        int elem = 0;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int c = 0;
            for (int i = 0; i < a.length; ++i) {
                int pos = Arrays.binarySearch(a[i], mid);
                if (pos < 0) pos = Math.abs(pos + 1);
                else
                    while (pos < a[0].length && a[i][pos] <= mid)
                        pos++;
                c += pos;
            }
            int exp = (a.length * a[0].length + 1) / 2;
            if (c < exp)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }
}
