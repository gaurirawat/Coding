package revision;

import java.util.TreeMap;
//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class Pointer_lc_longest_continuous_array_with_absolute_difference_less_than_equal_to_k {
    public int longestSubarray(int[] nums, int limit) {
        if (nums.length == 0) {
            return 0;
        }
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int l = 0;
        int r = 0;
        int max = 0;
        while (r != nums.length) {
            while (map.isEmpty() || r != nums.length) {
                map.put(nums[r], r);
                int diff = (map.lastKey() - map.firstKey());
                if (diff > limit) {
                    break;
                }
                ++r;
            }
            max = Math.max(max, r - l);
            if (r == nums.length) {
                break;
            }
            boolean isLastNoMax = map.lastKey() == nums[r];
            if (isLastNoMax) {
                l = map.firstEntry().getValue() + 1;
            }
            else {
                l = map.lastEntry().getValue() + 1;
            }

            while (map.firstEntry().getValue() < l) {
                map.pollFirstEntry();
            }
            while (map.lastEntry().getValue() < l) {
                map.pollLastEntry();
            }
        }
        return max;
    }
}
