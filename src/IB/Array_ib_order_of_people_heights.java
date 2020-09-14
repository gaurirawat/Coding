package IB;

import java.util.*;

//https://www.interviewbit.com/problems/order-of-people-heights/
public class Array_ib_order_of_people_heights {
    public ArrayList<Integer> order(ArrayList<Integer> ht, ArrayList<Integer> fr) {
        ArrayList<Pair> l= new ArrayList<Pair>();
        for(int i=0;i<ht.size();++i)
            l.add(new Pair(ht.get(i), fr.get(i)));
        Collections.sort(l, Comparator.comparing(x->-x.ht));
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<l.size();++i)
            ans.add(l.get(i).fr,l.get(i).ht);
        return ans;
    }

    class Pair{
        int ht;int fr;
        public Pair(int i, int j){
            ht=i;
            fr=j;
        }
    }

}