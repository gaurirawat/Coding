package revision;
//https://leetcode.com/problems/word-search/submissions/
public class Graph_lc_word_search {
    /*
    complexity ref: https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
    space is O(L) and time is O(M * N * 4^L)
    N = row length
    M = col length
    L = word length
*/
    public boolean exist(char[][] board, String word) {
        char[] letters=word.toCharArray();
        for(int i=0;i<board.length;++i) {
            for(int j=0;j<board[0].length;++j) {
                if(isWordPossible(0, i, j, letters, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWordPossible(int i, int x, int y, char[] letters, char[][]board) {
        if(i==letters.length) {
            return true;
        }
        if(x<0 ||y<0 || x>=board.length || y>=board[0].length || board[x][y]!=letters[i]) {
            return false;
        }
        board[x][y]='0';
        if(isWordPossible(i+1,x+1, y, letters, board) ||
                isWordPossible(i+1,x-1, y, letters, board) ||
                isWordPossible(i+1,x, y+1, letters, board) ||
                isWordPossible(i+1,x, y-1, letters, board)){
            return true;
        }
        board[x][y]=letters[i];
        return false;
    }
}
