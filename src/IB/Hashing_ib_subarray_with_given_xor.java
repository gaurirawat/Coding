package IB;

import java.util.*;

//https://www.interviewbit.com/problems/subarray-with-given-xor/
public class Hashing_ib_subarray_with_given_xor {
    public int solve(ArrayList<Integer> a, int k) {
        int c=0;
        int xor=0;
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        map.put(0,1);
        for(int i=0;i<a.size();++i){
            xor^=a.get(i);
            int t=map.getOrDefault(xor^k, 0);
            c+=t;
            map.put(xor,map.getOrDefault(xor, 0)+1);
        }
        return c;
    }
}