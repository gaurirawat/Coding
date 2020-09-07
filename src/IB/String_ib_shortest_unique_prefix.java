package IB;

import java.util.*;

//https://www.interviewbit.com/problems/shortest-unique-prefix/
public class String_ib_shortest_unique_prefix {
    public ArrayList<String> prefix(ArrayList<String> l) {
        HashMap<String,ArrayList<Integer>> map=new HashMap<String,ArrayList<Integer>>();
        ArrayList<String> ans=new ArrayList<String>();
        for(int i=0;i<l.size();++i)
            ans.add("");
        for(int i=0;i<l.size();++i){
            String s=l.get(i).charAt(0)+"";
            ArrayList<Integer> t=map.getOrDefault(s,new ArrayList<Integer>());
            t.add(i);
            map.put(s,t);
        }
        while(map.size()!=0){
            // System.out.println(map.toString());
            HashMap<String,ArrayList<Integer>> newmap=new HashMap<String,ArrayList<Integer>>();
            for(Map.Entry<String, ArrayList<Integer>> e: map.entrySet()){
                if(e.getValue().size()==1)
                    ans.set(e.getValue().get(0),l.get(e.getValue().get(0)).substring(0,e.getKey().length()));
                else{
                    for(int x:e.getValue()){
                        String s=l.get(x).substring(0,e.getKey().length()+1);
                        ArrayList<Integer> t=newmap.getOrDefault(s,new ArrayList<Integer>());
                        t.add(x);
                        newmap.put(s,t);
                    }
                }
            }
            map.clear();
            map=newmap;
        }
        return ans;
    }
}
