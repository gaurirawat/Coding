package revision;

import java.util.*;
//https://leetcode.com/problems/number-of-ways-to-split-a-string/
public class String_lc_no_of_ways_to_split_a_string {
    public int numWays(String s) {
        char ch[]=s.toCharArray();
        int ones=0;
        for(int i=0;i<ch.length;++i)
            ones+= (ch[i]=='1'?1:0);
        if(ch.length<=2|| ones%3!=0)
            return 0;
        int mod=(int)Math.pow(10,9)+7;
        if(ones==0){
            long count=0;
            for(int i=0;i<ch.length-2;++i){
                count+=ch.length-i-2;
            }
            count=count%mod;
            return (int)count;
        }

        int t=ones/3;
        int i=0;
        for(;i<ch.length;++i){
            if(ch[i]=='1'){
                --t;
                if(t==0)
                    break;
            }
        }
        ++i;
        int lpos=1;
        while(ch[i]=='0'){
            lpos++;
            ++i;
        }

        t=ones/3;
        i=ch.length-1;
        for(;i>=0;--i){
            if(ch[i]=='1'){
                --t;
                if(t==0)
                    break;
            }
        }
        --i;
        int rpos=1;
        while(ch[i]=='0'){
            rpos++;
            i--;
        }
        long count=1;
        count=count*lpos*rpos;
        count%=mod;
        return (int)count;
    }
}