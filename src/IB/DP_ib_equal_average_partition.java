package IB;

import java.util.*;

public class DP_ib_equal_average_partition {
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> a) {
        int sum = 0;
        for (int x: a) {
            sum += x;
        }
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        boolean flag = findPartition(0, 0, indexes, sum, a);

        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>> ();
        if (!flag) {
            return answer;
        }

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        int c = 0;
        for (int i=0; i<a.size(); ++i) {
            if(c!= indexes.size() && indexes.get(c) == i) {
                list1.add(a.get(i));
                c++;
            }
            else{
                list2.add(a.get(i));
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        answer.add(list1);
        if(list2.size()<list1.size()) {
            answer.add(0,list2);
        }
        else{
            answer.add(list2);
        }
        return answer;
    }

    public boolean findPartition(int i, int currSum, ArrayList<Integer> indexes, int sum, ArrayList<Integer> a) {
        if (currSum*1.0/indexes.size() == (sum-currSum)*1.0/(a.size()-indexes.size())) {
            return true;
        }
        if (i == a.size()) {
            return false;
        }

        indexes.add(i);
        if (findPartition(i+1, currSum+a.get(i), indexes, sum, a )) {
            return true;
        }

        indexes.remove(indexes.size()-1);

        return findPartition(i+1, currSum, indexes, sum, a);
    }
}
