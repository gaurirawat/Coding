package revision;
//https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/
public class Matrix_Array_search_element_in_rowwise_comumnwise_sorted_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=matrix.length-1;
        int j=0;
        int rows = matrix.length;
        int col = matrix[0].length;
        while(i>=0 && j<col) {
            int number= matrix[i][j];
            if( number == target) {
                return true;
            }
            else if( number <target) {
                ++j;
            }
            else{
                --i;
            }
        }
        return false;
    }
}
