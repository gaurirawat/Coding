package revision;

import java.util.*;
//https://leetcode.com/problems/flatten-nested-list-iterator/#:~:text=Flatten%20Nested%20List%20Iterator%20%2D%20LeetCode&text=Given%20a%20nested%20list%20of,be%20integers%20or%20other%20lists.

public class Implementation_lc_iterator_flatten_nested_list {

    // constant space complexity
    public class NestedIterator_constant_SC implements Iterator<Integer> {
        Deque<NestedInteger> stack;
        public NestedIterator_constant_SC(List<NestedInteger> nestedList) {
            stack = new LinkedList<NestedInteger>();
            insertListInStack(nestedList);

            while (!stack.isEmpty() && !stack.peekFirst().isInteger()) {
                insertListInStack(stack.pollFirst().getList());
            }
        }


        @Override
        public Integer next() {
            int val = stack.pollFirst().getInteger();
            while (!stack.isEmpty() && !stack.peekFirst().isInteger()) {
                insertListInStack(stack.pollFirst().getList());
            }
            return val;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public void insertListInStack(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; --i) {
                stack.addFirst(nestedList.get(i));
            }
        }

    }


    // N space complexity
    public class NestedIterator_SC_N implements Iterator<Integer> {
        ArrayList<Integer> list;
        int i;

        public NestedIterator_SC_N(List<NestedInteger> nestedList) {
            i = 0;
            list = new ArrayList<Integer>();
            inner(nestedList);
        }

        public void inner(List<NestedInteger> nestedList) {
            for (NestedInteger nesInt : nestedList) {
                if (nesInt.isInteger()) {
                    list.add(nesInt.getInteger());
                }
                else {
                    inner(nesInt.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(i++);
        }

        @Override
        public boolean hasNext() {
            return i != list.size();
        }
    }

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }
}
