package IB;

import java.util.ArrayList;

//interviewbit.com/problems/leaders-in-an-array/
public class Array_ib_leaders_in_an_array {
    public ArrayList<Integer> solve(ArrayList<Integer>a) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int i = a.size() - 1; i >= 0; --i) {
            if (a.get(i) > max) {
                l.add(a.get(i));
                max = a.get(i);
            }
        }
        return l;
    }
}
