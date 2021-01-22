package revision;
//https://leetcode.com/problems/split-array-largest-sum/
public class BSearch_lc_split_array_largest_sum {
    public int splitArray(int[] nums, int m) {
        int l = Integer.MAX_VALUE;
        int r = 0;

        for (int x : nums) {
            l = Math.min(l, x);
            r += x;
        }

        int answer = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int maxSum = getMaxSumPossible(nums, mid, m);
            if (maxSum == -1) {
                l = mid + 1;
            } else {
                r = maxSum - 1;
                answer = maxSum;
            }
        }
        return answer;
    }

    public int getMaxSumPossible(int[] nums, int mid, int m) {
        int currSum = 0;
        int maxSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            currSum += nums[i];
            if (currSum > mid || i + m - 1 == nums.length) {
                m--;
                currSum = nums[i];
            }
            if (m == 0 || nums[i] > mid) {
                return -1;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
