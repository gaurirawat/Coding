package IB;

import java.util.*;
//https://leetcode.com/problems/combination-sum/submissions/
//https://www.interviewbit.com/problems/combination-sum/
public class Backtracking_ib_combination_sum {
    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int t) {
        ans= new ArrayList<ArrayList<Integer>>();
        TreeSet<Integer> set=new TreeSet<Integer>(a);
        a.clear();
        a.addAll(set);
        combinationSumInner(0,0,t,a,new ArrayList<Integer>());
        return ans;
    }

    public void combinationSumInner(int i, int sum, int t, ArrayList<Integer> a,ArrayList<Integer> l){
        if(sum==t){
            ans.add(new ArrayList<Integer>(l));
            return;
        }
        if(i==a.size()||sum>t) return;
        if(sum+a.get(i)<=t){
            l.add(a.get(i));
            combinationSumInner(i,sum+a.get(i),t,a,l);
            l.remove(new Integer(a.get(i)));
        }
        combinationSumInner(i+1,sum,t,a,l);
    }
}
/*
//to handle duplicates
    HashSet<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] a, int t) {
        ans= new HashSet<List<Integer>>();
        Arrays.sort(a);
        combinationSumInner(0,0,t,a,new ArrayList<Integer>());
        List<List<Integer>> ansl=new ArrayList<List<Integer>>();
        for(List<Integer> x:ans)
            ansl.add(x);
        return ansl;
    }

    public void combinationSumInner(int i, int sum, int t,int []a,ArrayList<Integer> l){
        if(sum==t){
            ans.add(new ArrayList<Integer>(l));
            return;
        }
        if(i==a.length||sum>t) return;
        if(sum+a[i]<=t){
            l.add(a[i]);
            combinationSumInner(i,sum+a[i],t,a,l);
            l.remove(new Integer(a[i]));
        }
        combinationSumInner(i+1,sum,t,a,l);
    }
 */
