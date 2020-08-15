package IB;

import java.util.*;

//https://www.interviewbit.com/problems/distinct-numbers-in-window/
public class Heap_ib_distinct_numbers_in_windows {
    public ArrayList<Integer> dNums(ArrayList<Integer> a, int b) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer> ();
        ArrayList<Integer> ans= new ArrayList<Integer>();
        int disElem=0;
        int i;
        for(i=0;i<a.size() && i<b;++i){
            if(map.get(a.get(i))==null){
                map.put(a.get(i),1);
                disElem++;
            }
            else
                map.put(a.get(i),map.get(a.get(i))+1);
        }
        ans.add(disElem);

        if(i==a.size()) return ans;

        for(i=b;i<a.size();++i){

            int addE=a.get(i);
            int delE=a.get(i-b);

            if(addE==delE){
                ans.add(disElem);
                continue;
            }

            if(map.get(addE)==null)
                map.put(addE,1);
            else
                map.put(addE,map.get(addE)+1);
            map.put(delE,map.get(delE)-1);

            if(map.get(addE)==1) disElem++;
            if(map.get(delE)==0) disElem--;

            ans.add(disElem);
        }
        return ans;
    }
}
