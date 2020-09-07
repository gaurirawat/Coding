package IB;

import java.util.*;
//https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
public class Graph_ib_finish_course_with_prerequisite {
    public int solve(int n, ArrayList<Integer> src, ArrayList<Integer> dest) {
        int in[]=new int[n];
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>> ();
        for(int i=0;i<src.size();++i){
            in[dest.get(i)-1]++;
            ArrayList<Integer> l=map.getOrDefault(src.get(i)-1, new ArrayList<Integer>());
            l.add(dest.get(i)-1);
            map.put(src.get(i)-1,l);
        }
        int count=0;
        Deque<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<n;++i)
            if(in[i]==0){
                count++;
                q.addLast(i);
            }
        while(q.size()!=0){
            int u=q.pollFirst();
            for(int v:map.getOrDefault(u, new ArrayList<Integer>())){
                in[v]--;
                if(in[v]==0){
                    count++;
                    q.addLast(v);
                }
            }
        }
        return count==n?1:0;
    }
}
