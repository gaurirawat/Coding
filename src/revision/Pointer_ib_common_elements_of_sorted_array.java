package revision;
//https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
import java.util.*;
public class Pointer_ib_common_elements_of_sorted_array {
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        int p=0, q=0;
        ArrayList<Integer> ans= new ArrayList<Integer>();
        while(p<a.size() && q<b.size()){
            if(a.get(p).compareTo(b.get(q))==0){
                ans.add(a.get(p));
                p++;
                q++;
            }
            else if(a.get(p)<b.get(q))
                ++p;
            else 
                ++q;
        }
        return ans;
    }
}
