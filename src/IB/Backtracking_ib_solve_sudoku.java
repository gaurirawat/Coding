package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/sudoku/
public class Backtracking_ib_solve_sudoku {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        boolean [][]row=new boolean[9][9];
        boolean [][]col=new boolean[9][9];
        boolean [][]box=new boolean[9][9];
        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                if(Character.isDigit(a.get(i).get(j))){
                    int num=a.get(i).get(j)-'0'-1;
                    int boxn=(i/3)*3 + (j/3);
                    row[i][num]=true;
                    col[j][num]=true;
                    box[boxn][num]=true;
                }
            }
        }
        fillup(a,row,col,box,0,0);
    }

    public boolean fillup(ArrayList<ArrayList<Character>> a, boolean[][]row, boolean[][]col, boolean[][]box, int i, int j){
        // System.out.println(a.toString());
        if(j==9) return fillup(a,row,col,box,i+1,0);
        if(i==9) return true;
        if(a.get(i).get(j)!='.')
            return fillup(a,row,col,box,i,j+1);
        else{
            for(int k=0;k<9;++k){
                int boxn=(i/3)*3 + (j/3);
                if(!row[i][k] && !col[j][k] && !box[boxn][k]){
                    row[i][k]=col[j][k]=box[boxn][k]=true;
                    a.get(i).set(j,((k+1)+"").charAt(0));
                    if(fillup(a,row,col,box,i,j+1))
                        return true;
                    row[i][k]=col[j][k]=box[boxn][k]=false;
                    a.get(i).set(j,'.');
                }
            }
            return false;
        }
    }
}
