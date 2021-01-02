package IB;

import java.util.*;

//https://www.interviewbit.com/problems/merge-intervals/

/*

Approach:
we need to add interval a to list of intervals l
case 1: list is empty.
    simply add element and return
we traverse on the list till the time l(i).end < a.start.
case 2: the interval does not overlap and has to be added in the end.
    we check that we have traversed the complete list and the (l(i).end < a.start) cond. did not fail. now directly add.
case 3: the interval does not overlap and has to be added in the front.
case 4: the interval does not overlap and has to be added at the pos where our cond failed.
    Both case 3 and 4 will be solved by directly checking for a.end<l(i).start. add the interval a at i position and
    return the list.
case 5: intervals overlap.
    for the ith interval put its start and end as the min and max of l(i)'s and a's start and end respectively.
    follow the merge method. keep removing the next intervals till the time they overlap and updating the end
    accordingly.

 */
public class Array_ib_merge_intervals {
    public ArrayList<Interval> insert(ArrayList<Interval> l, Interval a) {

        if (a == null) return l;

        //case 1: list is empty.
        if (l == null || l.size() == 0) {
            ArrayList<Interval> t = new ArrayList<Interval>();
            t.add(a);
            return t;
        }

        int i = 0;
        while (i != l.size() && a.start > l.get(i).end) i++;

        //case 2: the interval does not overlap and has to be added in the end.
        if (i == l.size()) {
            l.add(a);
            return l;
        }

        //case 3: the interval does not overlap and has to be added in the front.
        //case 4: the interval does not overlap and has to be added at the pos where our cond failed.
        if (a.end < l.get(i).start) {
            l.add(i, a);
            return l;
        }

        //case 5: intervals overlap.

        l.get(i).start = Math.min(l.get(i).start, a.start);
        l.get(i).end = Math.max(l.get(i).end, a.end);

        while (i < l.size() - 1) {
            if (l.get(i).end >= l.get(i + 1).start) {
                l.get(i).end = Math.max(l.get(i).end, l.get(i + 1).end);
                l.remove(i + 1);
            } else
                break;
        }
        return l;
    }


    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}