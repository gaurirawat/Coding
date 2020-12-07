package revision;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/odd-even-jump/submissions/
public class Array_lc_odd_even_jump {
    public int oddEvenJumps(int[] a) {
        boolean[] odd=new boolean[a.length];
        boolean[] even=new boolean[a.length];
        TreeMap<Integer, Integer> map=new TreeMap<Integer, Integer>();
        odd[a.length-1]=true;
        even[a.length-1]=true;
        int c=1;
        map.put(a[a.length-1],a.length-1);
        for(int i=a.length-2;i>=0;--i){
            Map.Entry<Integer, Integer> greaterEntry=map.ceilingEntry(a[i]);
            Map.Entry<Integer, Integer> smallerEntry=map.floorEntry(a[i]);
            if(greaterEntry!=null) {
                odd[i]=even[greaterEntry.getValue()];
            }

            if(smallerEntry!=null) {
                even[i]=odd[smallerEntry.getValue()];
            }
            if(odd[i]) {
                c++;
            }
            map.put(a[i],i);
        }
        return c;
    }
}
