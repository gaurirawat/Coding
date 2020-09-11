package IB;

import java.util.*;
//https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
public class Hashing_ib_largest_continuous_sequence_zero_sum {
    public ArrayList<Integer> lszero(ArrayList<Integer> a ) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer> ();
        int sum=0;
        map.put(0,-1);
        int l=0,r=0;
        for(int i=0;i<a.size();++i){
            sum+=a.get(i);
            int tl=map.getOrDefault(sum,-99);
            if(tl!=-99){
                if((i-tl)>(r-l)){
                    l=tl;
                    r=i;
                }
            }
            else
                map.put(sum,i);
        }

        ArrayList<Integer> ans= new ArrayList<Integer>();
        for(int i=l+1;i<=r;++i)
            ans.add(a.get(i));
        return ans;
    }
}
