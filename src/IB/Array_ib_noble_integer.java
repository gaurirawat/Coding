package IB;

import java.util.*;
//https://www.interviewbit.com/problems/noble-integer/
public class Array_ib_noble_integer {
    public int solve(ArrayList<Integer> l) {
        Collections.sort(l, Collections.reverseOrder());
        for(int i=0;i<l.size();++i){
            if(l.get(i)==i)
                return 1;
            while(i<l.size()-1 && l.get(i)==l.get(i+1))
                i++;
        }
        return -1;
    }
}
