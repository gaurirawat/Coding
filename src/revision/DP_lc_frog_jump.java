package revision;

import java.util.*;

//https://leetcode.com/problems/frog-jump/submissions/

public class DP_lc_frog_jump {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1 ) {
            return false;
        }
        HashSet<Integer> stoneSet = new HashSet<Integer>();
        for (int x: stones) {
            stoneSet.add(x);
        }
        HashMap<Integer, HashSet<Integer>> invalidDP = new HashMap<Integer, HashSet<Integer>>();
        return canCrossInner(1, 1, stoneSet, invalidDP, stones[stones.length- 1]);
    }

    public boolean canCrossInner(int i, int k, HashSet<Integer> stones, HashMap<Integer, HashSet<Integer>> invalidDP, int last) {
        if (i == last) {
            return true;
        }

        for (int x : new int[] {-1, 0 , 1}) {
            int newk = k + x;
            if (newk <= 0) {
                continue;
            }
            int newi = i + newk;
            if (stones.contains(newi) && (invalidDP.get(newi) == null || !invalidDP.get(newi).contains(newk))) {
                if (canCrossInner(newi, newk, stones, invalidDP, last)) {
                    return true;
                }
            }
        }
        HashSet<Integer> invalidK = invalidDP.getOrDefault(i, new HashSet<Integer>());
        invalidK.add(k);
        invalidDP.put(i, invalidK);
        return false;
    }
}
