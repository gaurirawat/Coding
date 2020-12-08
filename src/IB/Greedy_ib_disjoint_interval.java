package IB;

import java.util.*;
//https://www.interviewbit.com/problems/disjoint-intervals/
public class Greedy_ib_disjoint_interval {
    public int solve(int[][] a) {
        Arrays.sort(a, Comparator.comparingInt(x->x[1]));
        // map.put(-1,0);
        int c=1;
        int end=a[0][1];
        for(int i=0;i<a.length;++i){
            // System.out.println(map.toString());
            // System.out.println(e.toString()+" "+e.getValue());
            if(end<a[i][0]){
                c++;
                end=a[i][1];
            }
        }
        return c;
    }
}
/*

        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if(x[0]!=y[0])
                    return x[0]-y[0];
                else
                    return x[1]-y[1];
            }
        });
 */