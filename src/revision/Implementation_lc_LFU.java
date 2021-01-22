package revision;
import java.util.*;
/*
Ref:
https://leetcode.com/problems/lfu-cache/discuss/94657/Java-solutions-of-three-different-ways.-PriorityQueue-%3A-O(capacity)-TreeMap-%3A-O(log(capacity))-DoubleLinkedList-%3A-O(1)
https://leetcode.com/problems/lfu-cache/
*/
public class Implementation_lc_LFU {
    class LFUCache {
        HashMap<Integer, Entry> map;
        PriorityQueue<Entry> pq;
        int cap;
        int timestamp;

        public LFUCache(int capacity) {
            map = new HashMap<Integer, Entry>();
            pq = new PriorityQueue<Entry>((a, b) -> (a.freq != b.freq ? a.freq - b.freq : a.time - b.time));
            cap = capacity;
            timestamp = 0;
        }

        public int get(int key) {
            if (map.get(key) != null) {
                Entry entry = map.get(key);

                pq.remove(entry);
                entry.freq++;
                entry.time = timestamp++;
                pq.add(entry);

                return entry.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (cap == 0) {
                return;
            }

            if (map.get(key) == null && map.size() == cap) {
                map.remove(pq.poll().key);
            }

            if (map.get(key) == null) {
                Entry entry = new Entry(key, value, 1, timestamp++);
                map.put(key, entry);
                pq.add(entry);
            } else {
                Entry entry = map.get(key);

                pq.remove(entry);
                entry.freq++;
                entry.time = timestamp++;
                entry.value = value;

                pq.add(entry);
            }
        }

        class Entry {
            int value;
            int freq;
            int time;
            int key;

            public Entry(int a, int b, int c, int d) {
                key = a;
                value = b;
                time = d;
                freq = c;
            }
        }
    }
}
