package revision;
//https://leetcode.com/problems/valid-sudoku/submissions/
public class Array_lc_valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (row[i][num] || col[j][num] || box[(i/3)*3 + (j/3)][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    box[(i/3)*3 + (j/3)][num] = true;
                }
            }
        }
        return true;
    }
}
