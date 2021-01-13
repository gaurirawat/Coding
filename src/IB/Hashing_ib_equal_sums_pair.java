package IB;

import java.util.*;
//https://www.interviewbit.com/problems/equal/
public class Hashing_ib_equal_sums_pair {
    public ArrayList<Integer> equal(ArrayList<Integer> list) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                int sum  = list.get(i) + list.get(j);
                if (map.get(sum) != null) {
                    int a = map.get(sum).get(0);
                    int b = map.get(sum).get(1);
                    int c = i;
                    int d = j;
                    if (a < b && c < d && a < c && b != c && b != d) {
                        if (ans.size() == 0 || a < ans.get(0) ||
                                (a == ans.get(0) && b < ans.get(1)) ||
                                (a == ans.get(0) && b == ans.get(1) && c < ans.get(2)) ||
                                (a == ans.get(0) && b == ans.get(1) && c == ans.get(2) && d == ans.get(3))) {
                            ans.clear();
                            ans.add(a);
                            ans.add(b);
                            ans.add(c);
                            ans.add(d);
                        }
                    }
                } else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    map.put(sum, temp);
                }
            }
        }
        return ans;
    }
}
