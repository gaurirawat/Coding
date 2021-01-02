package revision;
    //https://leetcode.com/problems/set-matrix-zeroes/submissions/
/*
whichever row/col has to be zero, we store the information in the first row / col.
a[0][5] means 5th col will be zero and a[4][0] means 4th row will be zero.
since a[0][0] will be there for both 0th row and 0th col we do not use it otherwise if row 0 is zero and we mark it as
zero then at the time of solution generation our 0th col will also become zero even when it might not be zero.
 */
public class Array_lc_set_zeros {

    public void setZeroesConstantSpace(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowZero = false;
        boolean colZero = false;

        //checking if zeroth row or column have to be zero.
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                colZero = true;
            }
        }
        for (int j = 0; j < n; ++j) {
            if (matrix[0][j] == 0) {
                rowZero = true;
            }
        }

        // checking for all cells except zero row / col.
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set the rows/cells as zero.
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // now set the 0th row/cell
        if (rowZero){
            for (int j = 0; j < n; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (colZero) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


}
