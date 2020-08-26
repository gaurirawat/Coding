package IB;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/problems/sum-of-fibonacci-numbers/
/*
it's better to use the greedy approach here.
 */
public class Graph_ib_sum_of_fibonacci_number {
    int minAns;
    public int fibsum(int n) {
        if(n==1) return 1;
        ArrayList<Integer> fibo=new ArrayList<Integer>();
        int a=1;
        int b=1;
        fibo.add(1);
        while(b<n){
            int t=a+b;
            a=b;
            b=t;
            fibo.add(t);
        }
        minAns=Integer.MAX_VALUE;
        fibSumInner(n, fibo, 0);
        return minAns;
    }

    public void fibSumInner(int n, ArrayList<Integer> fibo, int nosIncluded){
        if(minAns<nosIncluded)
            return;

        if(fibo.contains(n))
            minAns=Math.min(nosIncluded+1,minAns);
        else{
            int pos= Collections.binarySearch(fibo, n);
            pos=Math.abs(pos+1)-1;
            fibSumInner(n-fibo.get(pos),fibo, nosIncluded+1);
        }
    }
}
