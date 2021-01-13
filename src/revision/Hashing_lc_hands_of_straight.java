package revision;

import java.util.TreeMap;

//https://leetcode.com/problems/hand-of-straights/submissions/
public class Hashing_lc_hands_of_straight {
    public boolean isNStraightHand(int[] hand, int k) {
        if (hand.length % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int x : hand) {
            map.put(x, map.getOrDefault(x,0) + 1);
        }

        while (!map.isEmpty()) {
            int min = map.firstKey();
            int minReq = map.get(min);
            for (int i = min; i < min + k; ++i) {
                Integer value = map.get(i);
                if (value == null || value.compareTo(minReq) < 0) {
                    return false;
                }

                if (value == minReq) {
                    map.remove(i);
                } else{
                    map.put(i, value - minReq);
                }
            }
        }
        return true;
    }
}