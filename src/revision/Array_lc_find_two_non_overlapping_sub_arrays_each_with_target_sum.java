package revision;

import java.util.*;
//https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
public class Array_lc_find_two_non_overlapping_sub_arrays_each_with_target_sum {
    public int minSumOfLengths(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] validSubArrayLengths = new int[arr.length];
        int sum = 0;
        int min = Integer.MAX_VALUE;

        map.put(0, -1);
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            validSubArrayLengths[i] =  i == 0 ? Integer.MAX_VALUE : validSubArrayLengths[i - 1];
            map.put(sum, i);

            if (map.get(sum - target) != null) {
                int pos = map.get(sum - target);
                if (pos != -1 && validSubArrayLengths[pos] != Integer.MAX_VALUE) {
                    min = Math.min(min, validSubArrayLengths[pos] + i - pos);
                }
                validSubArrayLengths[i] = Math.min(i - pos, validSubArrayLengths[i]);
            }
            // System.out.println(Arrays.toString(validSubArrayLengths));
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
