package IB;

import java.util.*;

//https://www.interviewbit.com/problems/merge-intervals/
public class Array_ib_merge_intervals {
    public ArrayList<Interval> insert(ArrayList<Interval> li, Interval i) {

        if(i==null){
            return li;
        }

        if(li==null || li.size()==0){
            ArrayList<Interval> lii=new ArrayList<Interval>();
            lii.add(i);
            li=lii;
            return li;
        }

        int c=0;
        while(c<li.size()){
            Interval curr=li.get(c);
            if(curr.start<i.start)
                c++;
            else
                break;
        }

        li.add(c,i);
        c= c<=1?1:c-1;
        while(c<li.size()){
            Interval curr=li.get(c);
            Interval prev=li.get(c-1);
            if(prev.end>=curr.start){
                prev.end=Math.max(prev.end,curr.end);
                li.remove(c);
            }
            else
                c++;
        }
        return li;
    }


    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
