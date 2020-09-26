package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/permutations/
public class Backtracking_ib_permutations {
    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ans= new ArrayList<ArrayList<Integer>>();
        inner(0,new boolean[a.size()],a,new ArrayList<Integer>());
        return ans;
    }

    public void inner(int len, boolean[]inc, ArrayList<Integer> a, ArrayList<Integer> l){
        if(len==inc.length){
            ArrayList<Integer> t= new ArrayList<Integer>();
            t.addAll(l);
            ans.add(t);
            return;
        }
        for(int i=0;i<inc.length;++i){
            if(!inc[i]){
                inc[i]=true;
                l.add(a.get(i));
                inner(len+1,inc,a,l);
                l.remove(a.get(i));
                inc[i]=false;
            }
        }
    }
}