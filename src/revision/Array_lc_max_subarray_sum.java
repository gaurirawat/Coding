package revision;
//https://leetcode.com/problems/maximum-subarray/
public class Array_lc_max_subarray_sum {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int cSum = 0;

        for (int x: nums) {
            cSum += x;
            maxSum = Math.max(maxSum, cSum);
            if(cSum < 0) {
                cSum = 0;
            }
        }
        return maxSum ;
    }
}
