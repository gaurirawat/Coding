package revision;

import java.util.*;
//https://leetcode.com/problems/min-stack/
public class Implementation_lc_min_stack {
    class MinStack {
        ArrayList<Integer> st;
        ArrayDeque<Integer> minPos;
        /** initialize your data structure here. */
        public MinStack() {
            st = new ArrayList<Integer>();
            minPos = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            st.add(x);
            if (minPos.isEmpty() || x < st.get(minPos.peekLast())) {
                minPos.addLast(st.size() - 1);
            }
        }

        public void pop() {
            st.remove(st.size() - 1);
            if (minPos.peekLast() == st.size()) {
                minPos.pollLast();
            }
        }

        public int top() {
            return st.get(st.size() - 1);
        }

        public int getMin() {
            return st.get(minPos.peekLast());
        }
    }
    class MinStack2 {
        ArrayDeque<Integer> st;
        ArrayDeque<Integer> min;
        /** initialize your data structure here. */
        public MinStack2() {
            st = new ArrayDeque<Integer>();
            min = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            st.addLast(x);
            if (min.isEmpty() || x <= min.peekLast()) {
                min.addLast(x);
            }
        }

        public void pop() {
            if (min.peekLast().equals(st.peekLast())) {
                min.pollLast();
            }
            st.pollLast();
        }

        public int top() {
            return st.peekLast();
        }

        public int getMin() {
            return min.peekLast();
        }
    }
}