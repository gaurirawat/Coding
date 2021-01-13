package revision;

import java.util.*;
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/
public class BSearch_lc_kth_smallest {
    public int kthSmallest(int[][] m, int k) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int arr[] : m)  {
            for (int x : arr) {
                l = Math.min(l, x);
                r = Math.max(r, x);
            }
        }

        int answer = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long count = 0;
            int same = 0;
            for (int i = 0; i < m.length; ++i) {
                int pos = Arrays.binarySearch(m[i], mid);
                if (pos < 0) {
                    pos = Math.abs(pos + 1);
                }
                else {
                    while (pos != 0 && m[i][pos] == m[i][pos-1]) {
                        pos--;
                    }
                }
                count += pos;
            }
            if (count < k) {
                answer = mid;
                l = mid +1;
            }
            else{
                r = mid - 1;
            }
        }

        return answer;
    }
}
