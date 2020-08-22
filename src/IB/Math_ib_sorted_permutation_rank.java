package IB;

import java.util.*;
//https://www.interviewbit.com/problems/sorted-permutation-rank/

/*
remember to put mod at the correct places. Here we ned to put mod at the time of calculating factorial also and not just
the rank
 */
public class Math_ib_sorted_permutation_rank {
    public int findRank(String s) {
        char crr[]=s.toCharArray();
        ArrayList<Character> l=new ArrayList<Character>();
        for(char c: crr)
            l.add(c);
        Collections.sort(l);

        long r=0;
        int mod=(int)Math.pow(10,6)+3;
        for(int i=0;i<crr.length;++i){
            char ch=crr[i];
            int pos=Collections.binarySearch(l,ch);
            r+=pos*fact(l.size()-1);
            r%=mod;
            l.remove(new Character(ch));
        }
        return (int)(r+1);
    }

    public int fact(int n){
        if(n<=2) return n;
        int mod=(int)Math.pow(10,6)+3;
        long x=1;
        for(int i=2;i<=n;++i){
            x=x*i;
            x%=mod;
        }
        return (int)x;
    }
}
