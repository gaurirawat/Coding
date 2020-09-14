package IB;

import java.util.*;

//https://www.interviewbit.com/problems/hotel-reviews/
public class Tree_ib_hotel_reviews {
    public ArrayList<Integer> solve(String gw, ArrayList<String> rev) {
        HashSet<String> set= new HashSet<String>();
        set.addAll(Arrays.asList(gw.split("_")));
        TreeMap<Integer, ArrayList<Integer>> map= new TreeMap<Integer, ArrayList<Integer>>(Collections.reverseOrder());

        for(int i=0;i<rev.size();++i){
            String r[]=rev.get(i).split("_");

            int c=0;
            for(String s:r)
                if(set.contains(s))
                    ++c;

            ArrayList<Integer> l=map.getOrDefault(c, new ArrayList<Integer>());
            l.add(i);
            map.put(c,l);
        }

        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet())
            ans.addAll(e.getValue());
        return ans;
    }
}
