package revision;
//https://leetcode.com/problems/increasing-triplet-subsequence/
public class Array_lc_increasing_triplet_subsequence {
    public boolean increasingTripletConstantSpace(int[] nums) {
        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int x : nums) {
            if (x < left) {
                left = x;
            } else if (x < mid && x > left) {
                mid = x;
            } else if (x > mid) {
                return true;
            }
        }

        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        boolean[] leftSmallExist = new boolean[nums.length];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (min < nums[i]) {
                leftSmallExist[i] = true;
            } else {
                min = nums[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0 ; --i) {
            if (max > nums[i]) {
                if (leftSmallExist[i]) {
                    return true;
                }
            } else {
                max = nums[i];
            }
        }
        return false;
    }


}
