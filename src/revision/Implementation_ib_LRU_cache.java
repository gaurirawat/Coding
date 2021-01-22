package revision;

import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/submissions/

public class Implementation_ib_LRU_cache {
    class LRUCache {
        LinkedHashMap<Integer, Integer> map;
        int cap;
        public LRUCache(int capacity) {
            map = new LinkedHashMap<Integer, Integer>();
            cap = capacity;
        }

        public int get(int key) {
            if (map.get(key) == null) {
                return -1;
            }
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);

            return val;
        }

        public void put(int key, int value) {
            if (map.get(key) != null) {
                map.remove(key);
            }
            if (map.size() == cap) {
                for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                    map.remove(e.getKey());
                    break;
                }
            }
            map.put(key, value);
        }
    }
}
