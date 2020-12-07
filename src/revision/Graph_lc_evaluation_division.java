package revision;

import java.util.*;

//https://leetcode.com/problems/evaluate-division/
public class Graph_lc_evaluation_division {
    public double[] calcEquation(List<List<String>> eq, double[] v, List<List<String>> q) {
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        int nov=0;
        for(int i=0;i<eq.size();++i) {
            if(map.get(eq.get(i).get(0))==null)
                map.put(eq.get(i).get(0),nov++);
            if(map.get(eq.get(i).get(1))==null)
                map.put(eq.get(i).get(1),nov++);
        }

        double[][] g= new double[nov][nov];
        for(int i=0;i<eq.size();++i) {
            int x=map.get(eq.get(i).get(0));
            int y=map.get(eq.get(i).get(1));
            g[x][y]=v[i];
            g[y][x]=1/v[i];
        }

        double[] ans=new double[q.size()];
        for(int i=0;i<q.size();++i) {
            if(map.get(q.get(i).get(0))==null||map.get(q.get(i).get(1))==null) {
                ans[i]=-1;
            }
            else{
                int x=map.get(q.get(i).get(0));
                int y=map.get(q.get(i).get(1));
                boolean[] visited=new boolean[nov];
                ans[i]=dfsEq(x,y,1D,g,visited);
            }
        }
        return ans;
    }

    public double dfsEq(int s, int d, double prod, double[][]g, boolean[] visited) {
        if(s==d) {
            return 1*prod;
        }
        visited[s]=true;
        double ans=-1;
        for(int i=0;i<g.length;++i) {
            if(!visited[i] && g[s][i]!=0) {
                ans=dfsEq( i, d, prod*g[s][i], g, visited);
                if(ans!=-1) {
                    break;
                }
            }
        }
        return ans;
    }
}
