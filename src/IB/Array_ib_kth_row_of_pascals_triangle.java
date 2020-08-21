package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
public class Array_ib_kth_row_of_pascals_triangle {
    public ArrayList<Integer> getRow(int n) {
        ArrayList<Integer> l=new ArrayList<Integer> ();
        l.add(1);
        if(n==0) return l;

        for(int i=1;i<=n;++i){
            ArrayList<Integer> t=new ArrayList<Integer>();
            t.add(1);
            for(int j=1;j<l.size();++j)
                t.add(l.get(j)+l.get(j-1));
            t.add(1);
            l=t;
        }
        return l;
    }
}
