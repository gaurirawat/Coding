package revision;

import java.util.*;

public class String_lc_no_of_good_ways_to_split_a_string {
    public int numSplits(String s) {
        char ch[]=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(char c:ch){
            if(map.get(c)==null)
                map.put(c,1);
            else
                map.put(c,map.get(c)+1);
        }
        int cnt=0;
        Set<Character> set=new HashSet<Character> ();
        for(int i=0;i<ch.length-1;++i){
            set.add(ch[i]);
            map.put(ch[i],map.get(ch[i])-1);
            map.remove(ch[i],0);
            if(set.size()==map.entrySet().size())
                cnt++;
        }
        return cnt;
    }
}
