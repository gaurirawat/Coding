package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/nqueens/
public class Backtracking_ib_n_queens {
    char ch[];
    ArrayList<ArrayList<String>> ans;
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ch=new char[n];
        for(int i=0;i<n;++i)
            ch[i]='.';
        boolean v[]=new boolean[n];
        boolean d[]=new boolean[2*n-1];
        boolean ad[]=new boolean[2*n-1];
        ans=new ArrayList<ArrayList<String>> ();
        solveInner(0,n,v,d,ad,new ArrayList<String>());
        return ans;
    }

    public void solveInner(int j, int n, boolean[]v, boolean[]d, boolean[]ad, ArrayList<String> l){
        if(j==n){
            ArrayList<String> s=new ArrayList<String>();
            s.addAll(l);
            ans.add(s);
            return;
        }
        for(int i=0;i<n;++i){
            if(!v[i] && !d[i+j] && !ad[i+n-1-j]){
                ch[i]='Q';
                l.add(new String(ch));
                ch[i]='.';
                v[i]=true; d[i+j]=true; ad[i+n-1-j]=true;

                solveInner(j+1,n,v,d,ad,l);

                v[i]=false; d[i+j]=false; ad[i+n-1-j]=false;
                ch[i]='Q';
                l.remove(new String(ch));
                ch[i]='.';
            }
        }
    }
}
