package revision;

import java.util.*;

public class Implementation_lc_iterator_flatten_nested_list {
    public class NestedIterator implements Iterator<Integer> {
        ArrayList<Integer> list;
        int i;

        public NestedIterator(List<NestedInteger> nestedList) {
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
