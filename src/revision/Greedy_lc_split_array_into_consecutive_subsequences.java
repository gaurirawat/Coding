package revision;

import java.util.*;
//https://leetcode.com/problems/split-array-into-consecutive-subsequences/
public class Greedy_lc_split_array_into_consecutive_subsequences {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        Arrays.sort(nums);
        for (int x : nums) {
            int len = 0;
            if (map.get(x) != null) {
                len = map.get(x).poll();
                if (map.get(x).size() == 0){
                    map.remove(x);
                }
            }

            PriorityQueue<Integer> pq = map.getOrDefault(x + 1, new PriorityQueue<Integer>());
            pq.add(len + 1);
            map.put(x + 1, pq);
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> e: map.entrySet()) {
            for (int x : e.getValue()) {
                if (x < 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
