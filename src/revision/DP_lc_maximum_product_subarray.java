package revision;
//https://leetcode.com/problems/maximum-product-subarray/submissions/
public class DP_lc_maximum_product_subarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int answer = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > 0) {
                maxProd = Math.max(nums[i], maxProd * nums[i]);
                minProd = Math.min(nums[i], minProd * nums[i]);
            } else {
                int maxProdNext = Math.max(nums[i], minProd * nums[i]);
                int minProdNext = Math.min(nums[i], maxProd * nums[i]);
                maxProd = maxProdNext;
                minProd = minProdNext;
            }
            answer = Math.max(answer, maxProd);
        }
        return answer;
    }
}
