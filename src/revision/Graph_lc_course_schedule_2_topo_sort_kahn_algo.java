package revision;

import java.util.*;
//https://leetcode.com/problems/course-schedule-ii/
//https://www.youtube.com/watch?v=tggiFvaxjrY
public class Graph_lc_course_schedule_2_topo_sort_kahn_algo {
    public int[] findOrder(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> l= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;++i)
            l.add(new ArrayList<Integer>());
        for(int i=0;i<pre.length;++i)
            l.get(pre[i][1]).add(pre[i][0]);
        int ans[]= new int[n];
        int c=topologicalSort(n,ans,l);
        if(c!=n)
            return new int[0];
        return ans;
    }

    public int topologicalSort(int n,int[]ans, ArrayList<ArrayList<Integer>> g){
        int ind[]=new int[n];
        for(ArrayList<Integer> l: g){
            for(int x: l)
                ind[x]++;
        }
        int c=0;
        Deque<Integer> q= new LinkedList<Integer>();
        for(int i=0;i<ind.length;++i)
            if(ind[i]==0)
                q.add(i);
        while(q.size()!=0){
            int x=q.pollFirst();
            ans[c++]=x;
            for(int y:g.get(x)){
                ind[y]--;
                if(ind[y]==0)
                    q.addLast(y);
            }
        }
        return c;
    }

}
