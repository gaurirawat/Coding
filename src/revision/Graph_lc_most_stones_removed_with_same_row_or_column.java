package revision;

import java.util.*;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/submissions/
public class Graph_lc_most_stones_removed_with_same_row_or_column {
    public int removeStones(int[][] stones) {
        HashMap<Integer, ArrayList<Integer>> xmap= new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer,  ArrayList<Integer>> ymap= new HashMap<Integer,  ArrayList<Integer>>();
        for(int i=0;i<stones.length;++i){
            int x=stones[i][0];
            int y=stones[i][1];

            ArrayList<Integer> l=xmap.getOrDefault(x,new  ArrayList<Integer>());
            l.add(i);
            xmap.put(x,l);

            l=ymap.getOrDefault(y,new  ArrayList<Integer>());
            l.add(i);
            ymap.put(y,l);
        }

        boolean visited[]=new boolean[stones.length];
        int ans=0;
        for(int i=0;i<stones.length;++i){
            if(!visited[i]){
                visited[i]=true;
                Deque<Integer> q=new LinkedList<Integer>();
                q.add(i);
                int c=0;
                while(!q.isEmpty()){
                    int curr=q.poll();
                    c++;

                    ArrayList<Integer> xl =xmap.get(stones[curr][0]);
                    for(int t:xl){
                        if(!visited[t]){
                            visited[t]=true;
                            q.add(t);
                        }
                    }

                    ArrayList<Integer> yl =ymap.get(stones[curr][1]);
                    for(int t:yl){
                        if(!visited[t]){
                            visited[t]=true;
                            q.add(t);
                        }
                    }
                }
                ans+=c-1;
            }
        }
        return ans;
    }
}
