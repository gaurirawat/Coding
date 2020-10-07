package IB;

import java.util.*;

//https://www.interviewbit.com/problems/two-out-of-three/
public class Hashing_ib_two_out_of_three {
    public ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        HashSet<Integer> ans= new HashSet<Integer>();
        HashSet<Integer> seta= new HashSet<Integer>();
        HashSet<Integer> setb= new HashSet<Integer>();

        seta.addAll(a);
        for(int i=0;i<b.size();++i)
            if(seta.contains(b.get(i)))
                ans.add(b.get(i));
            else
                setb.add(b.get(i));

        for(int i=0;i<c.size();++i)
            if(seta.contains(c.get(i))||setb.contains(c.get(i)))
                ans.add(c.get(i));

        ArrayList<Integer> l = new ArrayList<Integer>();
        l.addAll(ans);
        Collections.sort(l);
        return l;
    }
}