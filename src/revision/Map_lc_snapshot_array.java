package revision;

import java.util.*;

//https://leetcode.com/problems/snapshot-array/submissions/
public class Map_lc_snapshot_array {
    int snapI=-1;
    ArrayList<TreeMap<Integer, Integer>> l;
    public Map_lc_snapshot_array(int length) {
        l= new ArrayList<TreeMap<Integer, Integer>>();
        for(int i=0;i<length;++i) {
            TreeMap<Integer, Integer> map= new TreeMap<Integer, Integer>();
            map.put(-1,0);
            l.add(map);
        }
    }

    public void set(int index, int val) {
        l.get(index).put(snapI,val);
    }

    public int snap() {
        return ++snapI;
    }

    public int get(int index, int snap_id) {
        return l.get(index).lowerEntry(snap_id).getValue();
    }
}