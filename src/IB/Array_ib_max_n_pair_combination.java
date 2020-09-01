package IB;

import java.util.*;
//https://www.interviewbit.com/problems/n-max-pair-combinations/
public class Array_ib_max_n_pair_combination {
    public int[] solve(int[] a, int[] b) {
        PriorityQueue<Integer> minH=new PriorityQueue<Integer>();
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=a.length-1;i>=0;--i){
            for(int j=b.length-1; j>=0;--j){
                int sum=a[i]+b[j];
                if(minH.size()<a.length)
                    minH.add(sum);
                else if(sum>=minH.peek()){
                    minH.poll();
                    minH.add(sum);
                }
                else
                    break;
            }
        }
        int ans[]=new int[a.length];
        for(int i=0;i<a.length;++i){
            ans[a.length-1-i]=minH.poll();
        }
        return ans;
    }
}
