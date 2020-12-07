package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
public class Pointer_ib_remove_duplicate_form_sorted_array {

    public int removeDuplicates(ArrayList<Integer> a) {
        int i = 0;
        for (int j = 1; j < a.size(); j++)
            if (!a.get(i).equals(a.get(j)))
                a.set(++i, a.get(j));

        while (a.size() > i + 1)
            a.remove(a.size() - 1);

        return a.size();
    }
    /*
    public int removeDuplicates(ArrayList<Integer> a) {
        int l = 0;
        int r = 0;
        while (r<a.size()) {
            while(r+1<a.size() && a.get(r).compareTo(a.get(r+1))==0) {
                r++;
            }
            a.set(l++,a.get(r));
            r++;
        }
        while (a.size() > l )
          a.remove(a.size() - 1);

        return a.size();
    }

*/

}
