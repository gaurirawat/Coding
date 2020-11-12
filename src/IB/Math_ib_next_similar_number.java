package IB;

import java.util.*;

//https://www.interviewbit.com/problems/next-similar-number/
public class Math_ib_next_similar_number {
    public String solve(String s) {
        if(s.length()<=1) return "-1";
        char ch[]=s.toCharArray();
        ArrayList<Integer> l= new ArrayList<Integer>();
        l.add(ch[ch.length-1]-'0');
        int i=0; int curr=0;
        for(i=ch.length-2;i>=0;--i){
            curr=ch[i]-'0';
            int right=ch[i+1]-'0';
            l.add(curr);
            if(curr<right)
                break;
        }
        if(i==-1)
            return "-1";

        StringBuffer ans=new StringBuffer();
        ans.append(s.substring(0,i));
        Collections.sort(l);
        int pos=Collections.binarySearch(l,curr);
        while(l.get(pos)==l.get(pos+1))++pos;
        ans.append(l.remove(pos+1));
        for(int x:l)
            ans.append(x);
        return ans.toString();
    }
}
