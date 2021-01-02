package IB;
//https://www.interviewbit.com/problems/max-product-subarray/
public class DP_ib_max_product_subarray {
    public int maxProduct(final int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int maxP = nums[0];
        int minN = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            int x = nums[i];
            if (x > 0) {
                maxP = Math.max(x, maxP * x);
                minN = Math.min(x, minN * x);
            } else {
                int newMaxP = Math.max(x, minN * x);
                int newMinN = Math.min(x, maxP * x);
                maxP = newMaxP;
                minN = newMinN;
            }
            max = Math.max(max, maxP);
        }
        return max;
    }
}
