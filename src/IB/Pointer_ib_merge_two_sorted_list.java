package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
public class Pointer_ib_merge_two_sorted_list {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i=0,j=0;
        while(i!=a.size() && j!=b.size()){
            if(a.get(i)<b.get(j))
                ++i;
            else{
                a.add(i,b.get(j));
                i++;
                b.remove(j);
            }
        }
        if(b.size()!=0)
            a.addAll(b);
    }
}
