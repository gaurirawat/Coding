package revision;

import java.util.TreeSet;

//https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
public class DP_lc_max_sum_of_rectangle_no_larger_than_k {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] += i == 0 ? 0 : matrix[i - 1][j];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < m; ++r1) {
            for (int r2 = r1; r2 < m; r2++) {
                int[] cumulativeRows = new int[n];
                for (int j = 0; j < n; ++j) {
                    cumulativeRows[j] = matrix[r2][j] - (r1 == 0 ? 0 : matrix[r1 - 1][j]);
                }
                maxSum = Math.max(maxSum, getMaxSumLessThanK(cumulativeRows, k));
            }
        }

        return maxSum;
    }

    public int getMaxSumLessThanK(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(0);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            Integer lowerSum = set.ceiling(sum - k);
            if (lowerSum != null) {
                max = Math.max(max, sum - lowerSum);;
            }
            set.add(sum);
        }
        // System.out.println(max);
        return max;
    }
}
