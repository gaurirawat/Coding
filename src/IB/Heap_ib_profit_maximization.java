package IB;

import java.util.*;
//https://www.interviewbit.com/problems/profit-maximisation/
public class Heap_ib_profit_maximization {
    public int solve(int[] a, int k) {
        int sum=0;
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<a.length;++i)
            pq.add(a[i]);
        for(int i=0;i<k;++i){
            int x=pq.poll();
            sum+=x;
            pq.add(x-1);
        }
        return sum;
    }
}
