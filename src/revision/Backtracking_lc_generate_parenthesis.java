package revision;

import java.util.*;

//https://leetcode.com/problems/generate-parentheses/
public class Backtracking_lc_generate_parenthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        inner(0, 0, n, "", list);
        return list;
    }

    public void inner(int open, int close, int n, String s, ArrayList<String> list) {
        if (open == close && close == n) {
            list.add(s);
            return;
        }
        if (open != n) {
            inner(open + 1, close, n, s+"(", list);
        }
        if (open > close) {
            inner(open, close + 1, n, s+")", list);
        }
    }
}
