package revision;
//https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
import java.util.*;
public class Pointer_ib_merge_two_sorted_list {
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a.size()==0)
            a=b;
        int p=0;
        while(p!=a.size() && b.size()!=0){
            if(a.get(p)>b.get(0))
                a.add(p,b.remove(0));
            p++;
        }
        if(p==a.size() && b.size()!=0)
            a.addAll(b);
    }
}
