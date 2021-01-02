package IB;
//https://www.interviewbit.com/problems/minimum-parantheses/
public class String_ib_minimum_parenthesis {
    public int solve(String s) {
        int c = 0;
        int count = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                c++;
            }
            else if(ch == ')' && c == 0) {
                count++;
            }
            else {
                c--;
            }
        }
        count += c;
        return count;
    }
}
