package revision;

import java.util.*;
//https://leetcode.com/problems/insert-delete-getrandom-o1/submissions/
public class Implementation_lc_insert_delete_get_random {
    class RandomizedSet {
        HashMap<Integer, Integer> map;
        ArrayList<Integer> list;
        Random random;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<Integer, Integer>();
            list = new ArrayList<Integer> ();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.get(val) == null) {
                map.put(val, list.size());
                list.add(val);
                return true;
            } else {
                return false;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (map.get(val) == null) {
                return false;
            } else {
                int pos = map.get(val);
                int lastElem = list.get(list.size()-1);

                list.set(pos, lastElem);
                map.put(lastElem, pos);

                list.remove(list.size()-1);
                map.remove(val);
                return true;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
