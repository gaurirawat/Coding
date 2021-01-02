package IB;

import java.util.*;
//https://www.interviewbit.com/problems/3-sum-zero/
/*
the point to be taken care of is that sum ie both (0-a[i]) and (a[l]+a[r]) should be long.
Ie it should be written as (0l-a[i]) and (a[l]+0l+a[r]) otherwise the addition may still happen as int.
 */
public class Pointer_ib_3_sum_zero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> nums) {
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>> ();
        Collections.sort(nums);

        for (int i = 0; i < nums.size() -2; ++i) {
            if ( i!=0 && nums.get(i).equals(nums.get(i-1))) {
                continue;
            }

            int l = i + 1;
            int r = nums.size()-1;

            while(l<r) {
                long sum = 0L+ nums.get(i) + nums.get(l) + nums.get(r);
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(nums.get(i));
                    list.add(nums.get(l));
                    list.add(nums.get(r));
                    set.add(list);
                    ++l;
                    --r;
                }
                else if (sum < 0){
                    ++l;
                }
                else {
                    --r;
                }
            }
        }

        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> list : set) {
            answer.add(list);
        }
        return answer;
    }
}
