package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/min-sum-path-in-triangle/
public class DP_ib_min_sum_path_in_triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {

        for(int i=1;i<a.size();++i){
            for(int j=0;j<a.get(i).size();++j){
                int t=Integer.MAX_VALUE;
                if(j!=0)
                    t=a.get(i-1).get(j-1);
                if(j!=i)
                    t=Math.min(t,a.get(i-1).get(j));
                a.get(i).set(j,t+a.get(i).get(j));
            }
        }

        int min=Integer.MAX_VALUE;
        for(int x: a.get(a.size()-1))
            min=Math.min(min, x);
        return min==Integer.MAX_VALUE?0:min;
    }
}
