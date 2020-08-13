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
    Below gives TLE
    public int removeDuplicates(ArrayList<Integer> a) {
        int i=0;
        while(i<a.size()){
            while(i<a.size()-1 && a.get(i).intValue()==a.get(i+1).intValue())
                a.remove(i);
            i++;
        }
        return a.size();
    }
*/

}
