package revision;

import java.util.*;

public class Hashing_lc_calender {
    class MyCalendar {
        TreeMap<Integer, Integer> map;
        public MyCalendar() {
            map = new TreeMap<Integer, Integer>();
        }

        public boolean book(int st, int end) {
            Map.Entry<Integer, Integer> prev = map.floorEntry(st);
            if (prev == null || prev.getValue() <= st) {
                Map.Entry<Integer, Integer> next = map.ceilingEntry(st);
                if(next == null || next.getKey() >= end) {
                    map.put(st, end);
                    return true;
                }
            }
            return false;
        }
    }
}