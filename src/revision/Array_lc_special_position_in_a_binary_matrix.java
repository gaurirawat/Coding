package revision;
//https://leetcode.com/problems/special-positions-in-a-binary-matrix/
public class Array_lc_special_position_in_a_binary_matrix {
    public int numSpecial(int[][] mat) {
        int row[]= new int[mat.length];
        int col[]=new int[mat[0].length];
        int c=0;
        for(int i=0;i<mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j]==1){
                    if(getOnesR(i,row,mat)==1 && getOnesC(j,col,mat)==1)
                        c++;
                    continue;
                }
            }
        }
        return c;
    }

    public int getOnesR( int i, int[]row,int[][]mat){
        if(row[i]!=0) return row[i];
        for(int j=0;j<mat[0].length;++j)
            if(mat[i][j]==1)
                row[i]++;
        return row[i];
    }


    public int getOnesC(int j,int[]col,  int[][]mat){
        if(col[j]!=0) return col[j];
        for(int i=0;i<mat.length;++i)
            if(mat[i][j]==1)
                col[j]++;
        return col[j];
    }
}
