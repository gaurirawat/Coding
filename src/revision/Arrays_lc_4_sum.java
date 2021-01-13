package revision;

import java.util.HashMap;
//https://leetcode.com/problems/4sum-ii/submissions/
public class Arrays_lc_4_sum {
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int numa : a) {
            for (int numb : b) {
                map.put(numa + numb, map.getOrDefault(numa + numb, 0) + 1);
            }
        }

        int count = 0;
        for (int numa : c) {
            for (int numb : d) {
                count += map.getOrDefault(-(numa + numb), 0);
            }
        }
        return count;
    }
}
