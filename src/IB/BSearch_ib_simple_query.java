package IB;

import java.util.*;

//https://www.interviewbit.com/problems/simple-queries/
public class BSearch_ib_simple_query {
    public ArrayList<Integer> solve(ArrayList<Integer> num, ArrayList<Integer> q) {
        ArrayList<Integer> l=new ArrayList<Integer> ();
        for(int i=0;i<num.size();++i){
            int max=num.get(i);
            for(int j=i;j<num.size();++j){
                max=Math.max(max, num.get(j));
                l.add(max);
            }
        }
        Collections.sort(l, Collections.reverseOrder());
        for(int i=0;i<l.size();++i){
            int n=l.get(i);
            int d=divisors(l.get(i));
            l.set(i,d);
            while(i+1<l.size() && l.get(i+1)==n){
                ++i;
                l.set(i,d);
            }
        }
        Collections.sort(l, Collections.reverseOrder());
        // System.out.println("hello"+l.toString());
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int e:q)
            ans.add(l.get(e-1));
        return ans;
    }

    public int divisors(int n){
        int mod=(int)Math.pow(10,9)+7;
        long prod=n;
        for(int i=2;i<=n/2;++i){
            if(n%i==0){
                prod*=i;
                prod%=mod;
            }
        }
        return (int)prod;
    }
}