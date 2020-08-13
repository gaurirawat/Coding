package IB;

import java.util.*;
//https://www.interviewbit.com/problems/3-sum-zero/
/*
the point to be taken care of is that sum ie both (0-a[i]) and (a[l]+a[r]) should be long.
Ie it should be written as (0l-a[i]) and (a[l]+0l+a[r]) otherwise the addition may still happen as int.
 */
public class Pointer_ib_3_sum_zero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        HashSet<ArrayList<Integer>> set= new HashSet<ArrayList<Integer>>();
        Collections.sort(a);

        for(int i=0;i<a.size();++i){
            while(i!=0 && i<a.size() && a.get(i)==a.get(i-1)) i++;
            if(i==a.size()) break;
            long sum=0l-a.get(i);
            int l=i+1, r=a.size()-1;
            while(l<r){
                long temp=a.get(l)+0l+a.get(r);
                if(temp==sum){
                    ArrayList<Integer> ls= new ArrayList<Integer>();
                    ls.add(a.get(i));
                    ls.add(a.get(l));
                    ls.add(a.get(r));
                    set.add(ls);
                    l++;
                    r--;
                }
                else if(temp<sum)  l++;
                else --r;
            }
        }

        ArrayList<ArrayList<Integer>> ans =new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> l: set){
            ans.add(l);
        }
        return ans;
    }
}
