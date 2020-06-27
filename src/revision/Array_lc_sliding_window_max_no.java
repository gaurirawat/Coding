package revision;
import java.util.*;

// understanding(3rd method-deque): https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
//we're not using that here since that gives poor speed. Use of collections increases time consumption.

public class Array_lc_sliding_window_max_no {
	 public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) { // Find max for first initial k values
                if (max <= nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                    ans[0] = max;
                }
            } else {
                if (maxIndex >= i - k + 1) { // If maxIndex is within window range, compare max with current number
                    if (max <= nums[i]) {
                        max = nums[i];
                        maxIndex = i;
                    }
                } else { // Else find new max within the window
                    max = nums[i];
                    maxIndex = i;
                    for (int j = i - k + 1; j <= i; j++) {
                        if (max <= nums[j]) {
                            max = nums[j];
                            maxIndex = j;
                        }
                    }
                }
                ans[i-k+1] = max;
            }
        }
        return ans;
    }
}