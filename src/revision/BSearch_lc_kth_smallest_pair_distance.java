package revision;

import java.util.Arrays;
//https://leetcode.com/problems/find-k-th-smallest-pair-distance/

public class BSearch_lc_kth_smallest_pair_distance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];

        int answer = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int count = countPairsLessThanMid(nums, mid);
            if (count < k) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }

    public int countPairsLessThanMid(int[] nums, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            int invalidPair = nums[i] + mid;
            int pos = Arrays.binarySearch(nums, invalidPair);
            if (pos < 0) {
                pos = Math.abs(pos + 1);
            }
            while (pos != 0 && pos != nums.length && nums[pos - 1] == invalidPair) {
                --pos;
            }
            count += pos - i - 1;
        }
        return count;
    }
}