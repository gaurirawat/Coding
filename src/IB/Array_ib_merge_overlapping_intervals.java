package IB;

import java.util.*;

public class Array_ib_merge_overlapping_intervals {
    public ArrayList<Interval> merge(ArrayList<Interval> l) {
        Collections.sort(l,Comparator.comparingInt(e->e.start));
        int i=0;
        while(i<l.size()){
            Interval elem=l.get(i);
            while(i+1<l.size() && elem.end>=l.get(i+1).start){
                elem.end=Math.max(elem.end, l.get(i+1).end);
                l.remove(i+1);
            }
            i++;
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
