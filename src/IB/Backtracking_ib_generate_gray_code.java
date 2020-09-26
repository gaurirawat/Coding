package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/gray-code/
public class Backtracking_ib_generate_gray_code {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        if(n==0) return l;
        l.add(0);l.add(1);
        for(int i=1;i<n;++i){
            int size=l.size();
            for(int j=size-1;j>=0;--j)
                l.add((int)(Math.pow(2,i)+l.get(j)));
        }
        return l;
    }
}