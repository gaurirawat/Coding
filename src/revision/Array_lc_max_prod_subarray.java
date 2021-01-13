package revision;
//https://leetcode.com/problems/maximum-product-subarray/submissions/
public class Array_lc_max_prod_subarray {
    public int maxProduct(int[] nums) {
        int maxPos = 1;
        int minNeg = 1;
        int maxProd = Integer.MIN_VALUE;

        for (int x: nums) {
            if (x > 0) {
                maxPos = Math.max(maxPos * x, x);
                minNeg = Math.min(minNeg * x, x);
            }
            else {
                int maxPosNew = Math.max(minNeg * x, x);
                int minNegNew = Math.min(maxPos * x, x);
                maxPos = maxPosNew;
                minNeg = minNegNew;
            }
            maxProd = Math.max(maxProd, maxPos);
        }

        return maxProd;
    }
}
