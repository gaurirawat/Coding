package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/pascal-triangle/
public class Array_ib_pascals_triangle {
    public ArrayList<ArrayList<Integer>> solve(int n) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        if(n==0) return ans;
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(1);
        ans.add(l);
        for(int i=1;i<n;++i){
            ArrayList<Integer> t=new ArrayList<Integer>();
            t.add(1);
            for(int j=1;j<i;++j)
                t.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
            t.add(1);
            ans.add(t);
        }
        return ans;
    }
}
