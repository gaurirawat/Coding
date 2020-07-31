package IB;

import java.util.*;

public class Heap_ib_LRU_cache {
    int cap;
    LinkedHashMap<Integer, Integer> map;
    public Heap_ib_LRU_cache(int capacity) {
        this.cap=capacity;
        map=new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {
        if(map.get(key)==null)
            return -1;
        int x=map.get(key);
        map.remove(key,x);
        map.put(key,x);
        return x;
    }

    public void set(int key, int value) {
        if(map.get(key)!=null){
            map.remove(key,map.get(key));
            map.put(key, value);
            return;
        }
        if(cap==map.size()){
            for(Map.Entry e:map.entrySet()) {
                map.remove(e.getKey(), e.getValue());
                break;
            }
        }
        map.put(key, value);
    }
}
