package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/
public class Pointer_ib_remove_duplicate_from_sorted_array_2 {
    public int removeDuplicates(ArrayList<Integer> a) {
        if(a.size()<=2) return a.size();
        int len=2;
        for (int i = 2; i < a.size(); i++) {
            if (!a.get(i).equals(a.get(len - 2)) || !a.get(i).equals(a.get(len - 1))){
                a.set(len, a.get(i));
                len++;
            }
        }
        return len;
    }
}
/*
    if(a.size()<=2) return a.size();
        int len=0;
        int i = 0;
        while (i<a.size()) {
            int c=0;
            int e=a.get(i);
            while(i!=a.size() && e==a.get(i)) {
                ++i;
                c++;
            }
            a.set(len++,e);
            if(c>1) {
                a.set(len++,e);
            }
        }
        return len;
 */