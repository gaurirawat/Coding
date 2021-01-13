package revision;

import java.util.*;
//https://leetcode.com/problems/range-module/
public class Implementation_lc_range_module {
    //interval approach
    class RangeModule {
        ArrayList<Interval> list;
        public RangeModule() {
            list = new ArrayList<Interval>();
        }

        public void addRange(int left, int right) {
            Interval interval= new Interval(left, right);

            int i = 0;
            while (i != list.size() && interval.st > list.get(i).st) {
                i++;
            }

            list.add(i, interval);
            if (i != 0 && list.get(i - 1).end >= list.get(i).st) {
                i--;
            }
            while (i + 1 != list.size() && list.get(i).end >= list.get(i + 1).st) {
                list.get(i).end = Math.max(list.get(i).end, list.get(i + 1).end);
                list.remove(i + 1);
            }
            // System.out.println("add: " + list.toString());
        }

        public boolean queryRange(int left, int right) {
            int i = 0;
            while(i != list.size() && list.get(i).end < left) {
                i++;
            }
            if (i != list.size() && list.get(i).st <= left && right <= list.get(i).end) {
                return true;
            }
            // System.out.println(list.toString());
            return false;

        }

        public void removeRange(int left, int right) {
            int i = 0;
            while (i != list.size() && list.get(i).end < left) {
                i++;
            }
            if (i == list.size()) {
                return;
            }
            if (list.get(i).st < left) {
                list.add(i, new Interval(list.get(i).st, left));
                i++;
            }

            while (i != list.size() && list.get(i).end <= right) {
                list.remove(i);
            }
            if (i != list.size() && list.get(i).st < right) {
                list.get(i).st = right;
            }

            // System.out.println("remove: " + list.toString());
        }

        class Interval{
            int st;
            int end;
            public Interval(int x, int y) {
                st = x;
                end = y;
            }
            public String toString() {
                return "[" + st + "," + end +"]";
            }
        }
    }

    //map approach
    class RangeModuleMap {
        TreeMap<Integer, Integer> map;
        public RangeModuleMap() {
            map = new TreeMap<Integer, Integer>();
        }

        public void addRange(int left, int right) {
            while (true) {
                Map.Entry<Integer, Integer> entry = map.floorEntry(right);
                if (entry == null || entry.getValue() < left) {
                    break;
                }
                left = Math.min(left, entry.getKey());
                right = Math.max(right, entry.getValue());
                map.remove(entry.getKey());
            }
            map.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(left);
            if (entry != null && entry.getValue() >= right) {
                return true;
            }
            return false;
        }

        public void removeRange(int left, int right) {
            addRange(left, right);
            Map.Entry<Integer, Integer> entry = map.floorEntry(left);
            map.remove(entry.getKey());
            if (entry != null && entry.getKey() < left) {
                map.put(entry.getKey(), left);
            }
            if (entry != null && entry.getValue() > right) {
                map.put(right, entry.getValue());
            }
        }
    }


}
