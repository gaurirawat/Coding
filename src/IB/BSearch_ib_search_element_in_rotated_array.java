package IB;

import java.util.List;

//https://www.interviewbit.com/problems/rotated-sorted-array-search/
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class BSearch_ib_search_element_in_rotated_array {
    public int search(final List<Integer> nums, int k) {
        int pivot = getRotatedArrayPivot(nums);
        int pos = binarySearch(nums, 0, pivot - 1, k);
        if (pos == -1) {
            pos = binarySearch(nums, pivot, nums.size() - 1, k);
        }
        return pos;
    }

    public int binarySearch(final List<Integer> nums, int l, int r, int k) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) == k) {
                return mid;
            } else if (nums.get(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int getRotatedArrayPivot(List<Integer> nums) {
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int mid = l +(r - l) / 2;
            if (nums.get(mid) < nums.get(r)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
