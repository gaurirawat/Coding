package IB;
//https://www.interviewbit.com/problems/permutation-swaps/
public class Graph_ib_permutation_swaps {
    public int solve(int[] a, int[] b, int[][] c) {
        int n=a.length;
        int[] set=new int[n+1];
        for(int i=0;i<=n;++i){
            set[i]=i;
        }
        for(int i=0;i<c.length;++i) {
            union(a[c[i][0]-1], a[c[i][1]-1], set);
        }
        for(int i=0;i<n;++i) {
            if(a[i]!=b[i] && !find(a[i], b[i], set)){
                return 0;
            }
        }
        return 1;
    }

    public void union(int a, int b, int[] set) {
        int roota=getRoot(a, set);
        set[roota]=set[b];
    }

    public boolean find(int a, int b, int[] set) {
        return getRoot(a,set)==getRoot(b,set);
    }

    public int getRoot(int a, int[] set){
        while(set[a]!=a){
            set[a]=set[set[a]];
            a=set[a];
        }
        return a;
    }
}
