package IB;

import java.util.*;
//https://www.interviewbit.com/problems/tushars-birthday-bombs/
public class DP_ib_tushars_birthday_bombs {
    public ArrayList<Integer> solve(int k, ArrayList<Integer> num) {
        int min=Collections.min(num);
        int rem=k%min;
        ArrayList<Integer>ans =new ArrayList<Integer>();
        int i=0;
        while(ans.size()<k/min){
            if(num.get(i)-min<=rem){
                ans.add(i);
                rem-=num.get(i)-min;
            }
            else
                ++i;
        }
        return ans;
    }
}
