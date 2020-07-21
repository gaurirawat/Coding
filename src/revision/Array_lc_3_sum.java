package revision;

import java.util.*;

//https://leetcode.com/problems/3sum/submissions/
public class Array_lc_3_sum {
    public List<List<Integer>> threeSum(int[] n) {
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        Arrays.sort(n);
        for(int i=0;i<n.length-1;++i){
            while(i!=0 && i<n.length && n[i]==n[i-1])++i;
            if(i==n.length)
                break;
            int sum=0-n[i];
            int l=i+1,r=n.length-1;
            while(l<r){
                if(n[l]+n[r]==sum){
                    ArrayList<Integer> t= new ArrayList<Integer>();
                    t.add(n[i]);
                    t.add(n[l]);
                    t.add(n[r]);
                    list.add(t);
                    while(l<r && n[l]==n[l+1])l++;
                    while(l<r && n[r]==n[r-1])r--;
                    ++l;--r;
                }
                else if(n[l]+n[r]<sum)
                    ++l;
                else
                    --r;
            }
        }
        return list;
    }
}
