package IB;

import java.util.*;

//https://www.interviewbit.com/problems/subsets-ii/
public class Backtracking_ib_subsets_2 {
    LinkedHashSet<ArrayList<Integer>> set;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
        Collections.sort(a);
        set = new LinkedHashSet<ArrayList<Integer>>();
        set.add(new ArrayList<Integer>());
        subsetInner(0, a, new ArrayList<Integer>());
        ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> t:set)
            ans.add(t);
        return ans;
    }

    public void subsetInner(int i, ArrayList<Integer> a, ArrayList<Integer> l){
        if(i>a.size()) return;

        ArrayList<Integer> t= new ArrayList<Integer>();
        t.addAll(l);
        set.add(t);

        for(;i<a.size();++i){
            l.add(a.get(i));
            subsetInner(i+1, a, l);
            l.remove(a.get(i));
        }
    }
}
