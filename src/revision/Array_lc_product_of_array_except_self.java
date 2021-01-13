package revision;
//https://leetcode.com/problems/product-of-array-except-self/
public class Array_lc_product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        int[] result = new int[nums.length];

        l[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            l[i] = nums[i - 1] * l[i - 1];
        }

        r[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            r[i] = nums[i + 1] * r[i + 1];
        }

        for (int i = 0; i < nums.length; ++i) {
            result[i] = l[i] * r[i];
        }
        return result;
    }

    public int[] productExceptSelfI(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int prod = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            prod = nums[i + 1] * prod;
            result[i] *= prod;
        }

        return result;
    }
}
