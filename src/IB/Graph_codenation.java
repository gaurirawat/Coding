package IB;

import java.util.*;

public class Graph_codenation {
    public int[] solve(int a[], int b[][], int c[][]){
        ArrayList<ArrayList<Integer>> l= new ArrayList<ArrayList<Integer>>();
        int in[]=new int[a.length];
        for(int i=0;i<a.length;++i){
            l.add(new ArrayList<Integer>());
        }
        for(int i=0;i<b.length;++i){
            l.get(b[i][0]-1).add(b[i][1]-1);
            l.get(b[i][1]-1).add(b[i][0]-1);
            in[b[i][0]-1]++;
            in[b[i][1]-1]++;
        }
        int root=0;
        for(int i=0;i<in.length;++i){
            if(in[i]==1) {
                root=i;
                break;
            }
        }
        int ans[]=new int[a.length];
        for(int i=0;i<c.length;++i){
            ans[i]=getAns(c[i][0]-1,c[i][1]-1, c[i][2], root, l,a);
        }
        return ans;
    }

    public int getAns(int s, int d, int k, int root, ArrayList<ArrayList<Integer>> l, int wt[]){
        int a=valLessThanK(root, -1,s,k, l, wt);
        int b=valLessThanK(root, -1,d,k, l, wt);
        int x=LCA(s, d,root, l);
        int c=valLessThanK(root, -1,x,k, l, wt);
        return a+b-c+ (wt[x]>k?1:0);
    }

    public int valLessThanK(int root, int parent, int x, int k, ArrayList<ArrayList<Integer>> l, int wt[]){
        if(root==x)
            return wt[root]<=k? 1:0;

    }
}
