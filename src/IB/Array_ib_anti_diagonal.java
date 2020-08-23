package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/anti-diagonals/
public class Array_ib_anti_diagonal {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> diag=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a.size()*2-1;++i)
            diag.add(new ArrayList<Integer>());
        for(int i=0;i<a.size();++i){
            for(int j=0;j<a.size();++j){
                diag.get(i+j).add(a.get(i).get(j));
            }
        }
        return diag;
    }
}
