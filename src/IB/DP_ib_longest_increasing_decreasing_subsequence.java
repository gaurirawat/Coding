package IB;

import java.util.*;
//https://www.interviewbit.com/problems/length-of-longest-subsequence/
public class DP_ib_longest_increasing_decreasing_subsequence {
    public int longestSubsequenceLength(final List<Integer> a) {
        if(a==null|| a.size()==0) return 0;
        ArrayList<Integer> mxIncLen=new ArrayList<Integer>();
        calcMaxIncLength(mxIncLen,a);

        ArrayList<Integer> b=new ArrayList<Integer>(a);
        Collections.reverse(b);
        ArrayList<Integer> mxDecLen=new ArrayList<Integer>();
        calcMaxIncLength(mxDecLen,b);
        Collections.reverse(mxDecLen);

        int max=0;
        for(int i=0;i<a.size();++i)
            max=Math.max(mxDecLen.get(i)+mxIncLen.get(i)+1,max);
        return max;
    }

    public void calcMaxIncLength(ArrayList<Integer> mxIncLen, List<Integer> a){
        ArrayList<Integer> lastElemForEachLen=new ArrayList<Integer>();
        for(int i=0;i<a.size();++i){
            int e=a.get(i);
            int pos=Collections.binarySearch(lastElemForEachLen,e);
            if(pos<0) pos=Math.abs(pos+1);
            if(pos<lastElemForEachLen.size())
                lastElemForEachLen.set(pos,e);
            else
                lastElemForEachLen.add(e);
            mxIncLen.add(pos);
        }
    }
}
