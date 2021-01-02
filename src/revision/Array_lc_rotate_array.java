package revision;
//https://leetcode.com/problems/rotate-array/submissions/
public class Array_lc_rotate_array {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0 || len <=1) {
            return;
        }

        //reverse all elements
        int l = 0;
        int r = len-1;
        while (l<r) {
            swap(l, r, nums);
            l++; r--;
        }

        //again reverse the elements
        l = 0;
        r = k - 1;
        while (l<r) {
            swap(l, r, nums);
            l++; r--;
        }

        l = k;
        r = len - 1;
        while (l<r) {
            swap(l, r, nums);
            l++; r--;
        }
    }

    public void swap(int i, int j, int[]nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
