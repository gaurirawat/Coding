package IB;

import java.util.ArrayList;
//interviewbit.com/problems/max-non-negative-subarray/
public class Array_ib_max_non_negative_sum {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int l = 0;
        int r = -1;
        int cl = 0;

        long sum = -1;
        long cSum = 0;
        for (int i=0; i<a.size(); ++i) {
            if (a.get(i)<0) {
                cl = i+1;
                cSum = 0;
                continue;
            } else {
                cSum += a.get(i);
                if (cSum > sum || (cSum == sum && r-l < (i-cl) )) {
                    l = cl;
                    r = i;
                    sum = cSum;
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i=l; i<=r; ++i) {
            answer.add(a.get(i));
        }
        return answer;
    }
}
