package IB;

import java.util.*;

//https://www.interviewbit.com/problems/magician-and-chocolates/
public class Heap_ib_magicians_and_chocolate {
    public int nchoc(int n, ArrayList<Integer> l) {
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.addAll(l);
        int mod=(int)Math.pow(10,9)+7;
        long c=0;
        for(int i=0;i<n && !pq.isEmpty();++i){
            int e=pq.poll();
            c+=e;
            c%=mod;
            pq.add(e/2);
        }
        return (int)c;
    }
}
