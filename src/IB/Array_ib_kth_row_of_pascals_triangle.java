package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
public class Array_ib_kth_row_of_pascals_triangle {
    public ArrayList<Integer> getRow(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i=1; i<=n; ++i) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);

            for(int j=0; j<list.size()-1; ++j) {
                temp.add(list.get(j)+ list.get(j+1));
            }

            temp.add(1);
            list = temp;
        }
        return list;
    }
}
