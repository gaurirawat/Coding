package IB;

import java.util.*;
//https://www.interviewbit.com/problems/merge-k-sorted-arrays/
public class Heap_ib_merge_k_sorted_arrays {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> a) {
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>(Comparator.comparingInt(pair->pair.num));
        for(int i=0;i<a.size();++i)
            pq.add(new Pair(a.get(i).remove(0),i));
        ArrayList<Integer> l= new ArrayList<Integer> ();
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            l.add(p.num);
            if(!a.get(p.list).isEmpty())
                pq.add(new Pair(a.get(p.list).remove(0),p.list));
        }
        return l;
    }
    class Pair{
        int num;
        int list;
        public Pair(int x,int y){
            num=x;
            list=y;
        }
    }
}