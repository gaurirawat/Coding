package IB;

import java.util.ArrayList;

//https://leetcode.com/problems/combinations/submissions/
//https://www.interviewbit.com/problems/combinations/
public class Backtracking_ib_combinations {
    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ans=new ArrayList<ArrayList<Integer>>();
        if(n==0)
            return ans;
        combination(new ArrayList<Integer>(), 1, n, k);
        return ans;
    }

    public void combination( ArrayList<Integer> l, int i, int n, int k){
        if(l.size()==k){
            ans.add(new ArrayList<Integer>(l));
            return ;
        }
        for(;i<=n;++i){
            l.add(i);
            combination(l,i+1,n,k);
            l.remove(new Integer(i));
        }
    }

}
