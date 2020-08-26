package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/black-shapes/
public class Graph_ib_black_shapes {
    ArrayList<String> srr;
    public int black(ArrayList<String> s) {
        srr=s;
        boolean visited[][]=new boolean[srr.size()][srr.get(0).length()];
        int count=0;
        for(int i=0;i<srr.size();++i){
            for(int j=0;j<srr.get(0).length();++j){
                if(!visited[i][j] && srr.get(i).charAt(j)=='X'){
                    dfs(i,j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, boolean visited[][]){
        visited[i][j]=true;
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        for(int k=0;k<4;++k){
            int ii=i+dx[k];
            int jj=j+dy[k];
            if(isValid(ii, jj) && srr.get(ii).charAt(jj)=='X' && !visited[ii][jj])
                dfs(ii,jj, visited);
        }
    }

    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<srr.size() && j<srr.get(0).length();
    }
}
