package revision;

import java.util.HashSet;

public class Array_lc_duplicate_element {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer> ();
        for (int n : nums) {
            if (set.contains(n)) {
                return n;
            }
            set.add(n);
        }
        return -1;
    }
}
