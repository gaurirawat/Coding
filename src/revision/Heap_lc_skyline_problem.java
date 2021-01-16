package revision;

import java.util.*;
//https://leetcode.com/problems/the-skyline-problem/submissions/

//ref:
//https://leetcode.com/problems/the-skyline-problem/discuss/61193/Short-Java-solution
public class Heap_lc_skyline_problem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<Cell> l = new ArrayList<Cell>();
        for (int[] arr : buildings) {
            l.add(new Cell(arr[0], arr[2]));
            l.add(new Cell(arr[1], -arr[2]));
        }
        Collections.sort(l, (a, b) -> (a.index != b.index ? a.index - b.index : -a.ht + b.ht));
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        PriorityQueue<Integer> maxHt = new PriorityQueue<Integer>(Comparator.reverseOrder());
        maxHt.add(0);

        int max = 0;
        for (Cell cell : l) {
            if (cell.ht > 0) {
                maxHt.add(cell.ht);
            } else {
                maxHt.remove(-cell.ht);
            }

            if (max != maxHt.peek()) {
                max = maxHt.peek();
                ArrayList<Integer> point = new ArrayList<Integer>();
                point.add(cell.index);
                point.add(max);
                answer.add(point);
            }
        }
        return answer;
    }

    class Cell {
        int index;
        int ht;

        public Cell(int a, int c) {
            index = a;
            ht = c;
        }
    }
}