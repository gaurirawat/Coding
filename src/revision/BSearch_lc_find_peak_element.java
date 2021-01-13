package revision;
//https://leetcode.com/problems/find-peak-element/submissions/
public class BSearch_lc_find_peak_element {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l<r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}
