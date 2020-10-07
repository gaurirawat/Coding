package IB;

import java.util.*;
//https://www.interviewbit.com/courses/programming/topics/heaps-and-maps/
public class Heap_ib_max_sum_combinations {
    public ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<Integer> b, int k) {
        Collections.sort(a, Collections.reverseOrder());
        Collections.sort(b, Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        outer: for(int i=0;i<a.size();++i){
            for(int j=0;j<b.size();++j){
                int num=a.get(i)+b.get(j);
                if(pq.size()<k)
                    pq.add(num);
                else if(num>pq.peek()){
                    pq.add(num);
                    pq.remove();
                }
                else
                    continue outer;
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<k;++i)
            ans.add(0,pq.poll());
        return ans;
    }
}
