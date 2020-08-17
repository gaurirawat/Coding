package IB;

import java.util.*;
//https://www.interviewbit.com/problems/smallest-sequence-with-given-primes/
public class DP_ib_smallest_sequence_with_given_primes{
    public int[] solve(int a, int b, int c, int n) {
        if(n==0) return new int[0];
        int ans[]=new int[n];
        SortedSet<Integer> minH=new TreeSet<Integer>();
        minH.add(a);
        minH.add(b);
        minH.add(c);
        int cnt=0;
        while(cnt!=n){
            int e=minH.first();
            minH.add(e*a);
            minH.add(e*b);
            minH.add(e*c);
            minH.remove(new Integer(e));
            ans[cnt++]=e;
        }
        return ans;
    }
}
