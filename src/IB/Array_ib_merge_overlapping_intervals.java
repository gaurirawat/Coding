package IB;

import java.util.*;
//https://www.interviewbit.com/problems/merge-overlapping-intervals/
public class Array_ib_merge_overlapping_intervals {
    public ArrayList<Interval> mergee(ArrayList<Interval> l) {
        Collections.sort(l, Comparator.comparingInt(a->a.start));

        for (int i=0; i<l.size(); ++i) {
            while ( i+1!=l.size() && l.get(i).end>=l.get(i+1).start) {
                l.get(i).end = Math.max(l.get(i).end, l.get(i+1).end);
                l.remove(l.get(i+1));
            }
        }
        return l;
    }

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
