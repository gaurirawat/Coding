package revision;
import java.util.*;
/*
Ref:
https://leetcode.com/problems/lfu-cache/discuss/94657/Java-solutions-of-three-different-ways.-PriorityQueue-%3A-O(capacity)-TreeMap-%3A-O(log(capacity))-DoubleLinkedList-%3A-O(1)
https://leetcode.com/problems/lfu-cache/
*/
public class Implementation_lc_LFU {
    HashMap<Integer, MetaData > map;
    PriorityQueue<MetaData> pq;
    int cap;
    int c;
    public Implementation_lc_LFU(int capacity) {
        cap=capacity;
        c=0;
        map=new HashMap<Integer, MetaData>();
        pq=new PriorityQueue<MetaData>();
    }

    public int get(int key) {
        if(cap==0){
            return -1;
        }
        MetaData metaData=map.get(key);
        if(metaData==null){
            return -1;
        }
        pq.remove(metaData);
        metaData.freq++;
        metaData.c=c++;
        pq.add(metaData);
        return metaData.val;
    }

    public void put(int key, int value) {
        if(cap==0){
            return;
        }
        MetaData metaData=map.get(key);
        if(metaData!=null) {
            pq.remove(metaData);
            metaData.freq++;
            metaData.c=c++;
            metaData.val=value;
            pq.add(metaData);
        } else {
            if(map.size()==cap) {
                MetaData toRemove=pq.poll();
                map.remove(toRemove.key,toRemove);
            }
            MetaData toAdd=new MetaData(key,value,1,c++);
            map.put(key,toAdd);
            pq.add(toAdd);
        }
    }

}
class MetaData implements Comparable<MetaData>{
    int key;
    int val;
    int freq;
    int c;
    public MetaData(int a, int b, int e, int d){
        key=a;
        val=b;
        freq=e;
        c=d;
    }

    public int compareTo( MetaData b) {
        MetaData a=this;
        if (a.freq != b.freq) {
            return a.freq - b.freq;
        }
        return a.c - b.c;
    }
}
