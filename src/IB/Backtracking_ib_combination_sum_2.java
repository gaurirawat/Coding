package IB;

import java.util.*;
//https://www.interviewbit.com/problems/combination-sum-ii/
public class Backtracking_ib_combination_sum_2 {
    HashSet<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        ans= new  HashSet<ArrayList<Integer>>();
        combinationSumInner(0,b,new ArrayList<Integer>(), a);
        ArrayList<ArrayList<Integer>> ansl=new ArrayList<ArrayList<Integer>> ();
        for(ArrayList<Integer> t:ans)
            ansl.add(t);
        return ansl;
    }

    public void combinationSumInner(int i, int sum, ArrayList<Integer> l, ArrayList<Integer> a){
        if(sum==0){
            ArrayList<Integer> t=new ArrayList<Integer>();
            t.addAll(l);
            ans.add(t);
            return;
        }
        if(i==a.size()) return;
        for(int j=i;j<a.size();++j){
            if(a.get(j)>sum) break;
            l.add(a.get(j));
            combinationSumInner(j+1,sum-a.get(j),l,a);
            l.remove(new Integer(a.get(j)));
        }
    }
}
