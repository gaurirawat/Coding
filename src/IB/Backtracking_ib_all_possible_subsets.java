package IB;

import java.util.*;
//https://www.interviewbit.com/problems/subset/
//https://leetcode.com/problems/subsets/
public class Backtracking_ib_all_possible_subsets {
    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        Collections.sort(a);
        ans= new ArrayList<ArrayList<Integer>>();
        ans.add(new ArrayList());
        permutation(0,a,new ArrayList<Integer>());
        return ans;
    }
    public void permutation(int x, ArrayList<Integer> a, ArrayList<Integer> l){
        for(int i=x;i<a.size();++i){
            l.add(a.get(i));
            ans.add(new ArrayList(l));
            permutation(i+1,a,l);
            l.remove(new Integer(a.get(i)));
        }
    }
}
