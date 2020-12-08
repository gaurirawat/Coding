package IB;

import java.util.HashMap;

//https://www.interviewbit.com/problems/first-repeating-element/
public class Hashing_ib_first_repeating_element {
    public int solve(int[] a) {
        int smIndex=a.length;
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<a.length;++i) {
            if(map.get(a[i])!=null){
                smIndex=Math.min(smIndex, map.get(a[i]));
            }
            else{
                map.put(a[i],i);
            }
        }
        return smIndex==a.length?-1:a[smIndex];
    }
}
