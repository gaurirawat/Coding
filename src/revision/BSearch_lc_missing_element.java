package revision;
//https://leetcode.com/problems/missing-element-in-sorted-array/submissions/
public class BSearch_lc_missing_element {
    public int missingElement(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int missing = getMissing(l, r, nums);
        if (missing < k) {
            return nums[r] + (k - missing);
        }

        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            missing = getMissing(l, mid, nums);
            if (k <= missing) {
                r = mid;
            } else{
                l = mid;
                k -= missing;
            }
        }
        return nums[l] + k;
    }

    public int getMissing(int l, int r, int[] nums) {
        return nums[r] - nums[l] - r + l;
    }
}
