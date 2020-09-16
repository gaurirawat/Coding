package IB;

import java.util.*;
//https://www.interviewbit.com/problems/4-sum/
public class Hashing_ib_4_sum {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> l, int t) {
        Collections.sort(l);
        LinkedHashSet<ArrayList<Integer>> set= new LinkedHashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
        for(int a=0;a<l.size();++a){
            for(int b=a+1;b<l.size();++b){
                int tMinusAB=t-l.get(a)-l.get(b);
                // System.out.println(tMinusAB);
                HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
                for(int c=b+1;c<l.size();++c){
                    if(map.get(l.get(c))!=null){
                        ArrayList<Integer> list= new ArrayList<Integer>();
                        list.add(l.get(a));
                        list.add(l.get(b));
                        list.add(map.get(l.get(c)));
                        list.add(l.get(c));
                        set.add(list);
                    }
                    else
                        map.put(tMinusAB-l.get(c),l.get(c));
                }
            }
        }

        for(ArrayList<Integer> list:set)
            ans.add(list);
        Collections.sort(ans, new CustomComparator());
        return ans;
    }
}

class CustomComparator implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
        if(a.get(0)!=b.get(0))
            return a.get(0).compareTo(b.get(0));
        else if(a.get(1)!=b.get(1))
            return a.get(1).compareTo(b.get(1));
        else if(a.get(2)!=b.get(2))
            return a.get(2).compareTo(b.get(2));
        return a.get(3).compareTo(b.get(3));
    }
}