package revision;

import java.util.ArrayDeque;
import java.util.Scanner;

//https://leetcode.com/problems/validate-stack-sequences/submissions/
public class Stack_lc_validate_stack_sequence{
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int a = 0;
        int b = 0;
        int n = pushed.length;
        if (pushed.length != popped.length) {
            return false;
        }

        ArrayDeque<Integer> st = new ArrayDeque<Integer>();
        while (a != n && b != n) {
            while (!st.isEmpty() && st.peekLast() == popped[b]) {
                b++;
                st.pollLast();
            }
            st.addLast(pushed[a++]);
        }

        while (!st.isEmpty() && st.peekLast() == popped[b]) {
            b++;
            st.pollLast();
        }

        if(st.isEmpty()) {
            return true;
        }
        return false;
    }
}
