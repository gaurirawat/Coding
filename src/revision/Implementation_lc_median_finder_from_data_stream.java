package revision;

import java.util.*;

//https://leetcode.com/problems/find-median-from-data-stream/submissions/
public class Implementation_lc_median_finder_from_data_stream {
    class MedianFinder {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap = new PriorityQueue<Integer> ();
            maxHeap = new PriorityQueue<Integer> (Collections.reverseOrder());
        }

        public void addNum(int num) {
            if (maxHeap.size() == minHeap.size()) {
                if(maxHeap.peek() == null || num <= maxHeap.peek()) {
                    maxHeap.add(num);
                }
                else {
                    minHeap.add(num);
                    maxHeap.add(minHeap.poll());
                }
            }
            else {
                if(num >= maxHeap.peek()) {
                    minHeap.add(num);
                }
                else {
                    maxHeap.add(num);
                    minHeap.add(maxHeap.poll());
                }
            }

        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            else{
                return maxHeap.peek();
            }
        }
    }
}
