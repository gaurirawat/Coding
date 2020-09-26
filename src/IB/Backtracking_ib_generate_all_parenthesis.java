package IB;

import java.util.ArrayList;

public class Backtracking_ib_generate_all_parenthesis {
    ArrayList<String> ans;
    public ArrayList<String> generateParenthesis(int n) {
        ans= new ArrayList<String>();
        if(n>0)
            inner("(",n-1,1);
        return ans;
    }

    public void inner(String s, int open, int close){
        if(open==0 && close==0)
            ans.add(s);
        if(open>0)
            inner(s+"(", open-1, close+1);
        if(close>0)
            inner(s+")", open, close-1);
    }
}
