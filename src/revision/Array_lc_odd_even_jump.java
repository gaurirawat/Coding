package revision;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/odd-even-jump/submissions/
public class Array_lc_odd_even_jump {
    public int oddEvenJumps(int[] a) {
        boolean[] odd=new boolean[a.length];
        boolean[] even=new boolean[a.length];
        TreeMap<Integer, Integer> map=new TreeMap<Integer, Integer>();
        map.put(a[a.length - 1], a.length - 1);
        even[a.length - 1] = true;
        odd[a.length - 1] = true;
        int c = 1;

        for (int i = a.length - 2; i >= 0; --i) {
            Map.Entry<Integer, Integer> oddJumpLocation = map.ceilingEntry(a[i]);
            if (oddJumpLocation != null && even[oddJumpLocation.getValue()]) {
                odd[i] = true;
                c++;
            }

            Map.Entry<Integer, Integer> evenJumpLocation = map.floorEntry(a[i]);
            if (evenJumpLocation != null && odd[evenJumpLocation.getValue()]) {
                even[i] = true;
            }

            map.put(a[i], i);
        }
        return c;
    }
}
