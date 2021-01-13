package revision;
//https://leetcode.com/problems/alphabet-board-path/submissions/
public class String_lc_alphabet_board_path {
    public String alphabetBoardPath(String target) {
        int i = 0;
        int j = 0;
        StringBuffer sb = new StringBuffer();

        for (char ch : target.toCharArray()) {
            int num = ch - 'a';
            int dx = num / 5 - i;
            int dy = num % 5 - j;

            if (dx < 0) {
                sb = addPath(sb, -dx, 'U');
            }
            if (dy > 0) {
                sb = addPath(sb, dy, 'R');
            }
            if (dy < 0) {
                sb = addPath(sb, -dy, 'L');
            }
            if (dx > 0) {
                sb = addPath(sb, dx, 'D');
            }
            sb.append('!');
            i = num / 5;
            j = num % 5;
        }

        return sb.toString();
    }

    public StringBuffer addPath(StringBuffer sb, int moves, char ch) {
        for (int i = 0; i < moves; ++i) {
            sb.append(ch);
        }
        return sb;
    }
}
