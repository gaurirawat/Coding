package revision;

import java.util.*;
//https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/submissions/
public class Array_lc_divide_array_into_set_of_k_consecutive_numbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0 || nums.length == k) {
            return false;
        }
        int root = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            root = Math.min(root, x);
        }

        while (!map.isEmpty()) {
            if (root == Integer.MAX_VALUE) {
                root = getRoot(map);
            }
            if (root +0L + k > Integer.MAX_VALUE) {
                return false;
            }
            int minFreq = map.get(root);
            int elem = root;
            root = Integer.MAX_VALUE;

            for (int i = 0; i < k; ++i) {
                if (map.get(elem + i) == null || map.get(elem + i) < minFreq) {
                    return false;
                }
                if (map.get(elem + i) > minFreq && root == Integer.MAX_VALUE) {
                    root = elem + i;
                }

                map.put(elem + i, map.get(elem + i) - minFreq);
                if (map.get(elem + i) == 0) {
                    map.remove(elem + i);
                }
            }
        }

        return true;
    }

    public int getRoot(HashMap<Integer, Integer> map) {
        int min = Integer.MAX_VALUE;
        for (int x: map.keySet()) {
            min = Math.min(x, min);
        }
        return min;
    }

    public boolean isPossibleDivide_nlogn(int[] nums, int k) {
        if (nums.length % k != 0 || nums.length == k) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int c = 0;
        while (c != nums.length) {
            int req = map.firstKey();
            for (int i = 0; i < k; ++i) {
                if (map.get(req) == null) {
                    return false;
                }
                int e = map.get(req);
                if ( e == 1) {
                    map.remove(req);
                }
                else{
                    map.put(req, e - 1);
                }
                req++;
                c++;
            }
        }

        return true;
    }
}
