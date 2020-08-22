package revision;

public class Array_lc_subrectangle_query {
    int arr[][];
    public Array_lc_subrectangle_query(int[][] rectangle) {
        arr=rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i=row1;i<=row2;++i){
            for(int j=col1;j<=col2;++j){
                arr[i][j]=newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return arr[row][col];
    }
}
