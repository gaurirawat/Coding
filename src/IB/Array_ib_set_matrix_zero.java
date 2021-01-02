package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/set-matrix-zeros/

//poor method.
// refer Array_lc_set_zeros for constant space method
// the rowSet and column set are not required. We are using them just to reduce complexity.

public class Array_ib_set_matrix_zero {
    boolean visited[][];
    boolean rowSet[];
    boolean columnSet[];
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        visited=new boolean[a.size()][a.get(0).size()];
        rowSet=new boolean[a.size()];
        columnSet=new boolean[a.get(0).size()];
        for(int i=0;i<a.size();++i){
            for(int j=0;j<a.get(0).size();++j){
                if(!visited[i][j] && a.get(i).get(j)==0 ){
                    setRowZero(i,a);
                    setColumnZero(j,a);
                }
                visited[i][j]=true;
            }
        }
    }

    public void setRowZero(int i, ArrayList<ArrayList<Integer>> a){
        if(rowSet[i]) return;
        rowSet[i]=true;
        for(int k=0;k<a.get(0).size();++k){
            if(a.get(i).get(k)==1){
                visited[i][k]=true;
                a.get(i).set(k,0);
            }
        }
    }

    public void setColumnZero(int j,ArrayList<ArrayList<Integer>> a){
        if(columnSet[j]) return;
        columnSet[j]=true;
        for(int k=0;k<a.size();++k){
            if(a.get(k).get(j)==1){
                visited[k][j]=true;
                a.get(k).set(j,0);
            }
        }
    }
}
