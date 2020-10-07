package IB;

import java.util.*;

//https://www.interviewbit.com/problems/an-increment-problem/
public class Hashing_ib_an_increment_problem {
    public ArrayList<Integer> solve(ArrayList<Integer> a) {
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        for(int i=0;i<a.size();++i){
            int num=a.get(i);
            if(map.get(num)==null)
                map.put(num, i);
            else{
                int pos=map.get(num);
                a.set(pos,num+1);
                map.put(num,i);
                map.put(num+1, Math.min(pos, map.getOrDefault(num+1, Integer.MAX_VALUE)));
            }
        }
        return a;
    }
}