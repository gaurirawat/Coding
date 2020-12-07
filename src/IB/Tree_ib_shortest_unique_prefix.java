package IB;

import java.util.*;

//https://www.interviewbit.com/problems/shortest-unique-prefix/
public class Tree_ib_shortest_unique_prefix {
    public ArrayList<String> prefix(ArrayList<String> l) {
        HashMap<String,ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>> ();
        ArrayList<String> ans = new ArrayList<String> (l.size());
        for(int i=0; i<l.size(); ++i) {
            String key = l.get(i).substring(0,1);
            ArrayList<Integer> temp =map.getOrDefault(key, new ArrayList<Integer>());
            temp.add(i);
            map.put(key, temp);
            ans.add("");
        }
        while (!map.isEmpty()) {
            HashMap<String,ArrayList<Integer>> newMap = new HashMap<String,ArrayList<Integer>> ();
            for(Map.Entry<String,ArrayList<Integer>> e: map.entrySet()) {
                if(e.getValue().size()==1) {
                    ans.set(e.getValue().get(0),e.getKey());
                }
                else{
                    int len = e.getKey().length()+1;
                    for(int x : e.getValue()) {
                        String key = l.get(x).substring(0,len);
                        ArrayList<Integer> temp =newMap.getOrDefault(key, new ArrayList<Integer>());
                        temp.add(x);
                        newMap.put(key, temp);
                    }
                }
            }
            map=newMap;
        }
        return ans;
    }
}
