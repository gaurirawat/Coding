package IB;

import java.util.List;

//https://www.interviewbit.com/problems/rain-water-trapped/
public class Stack_ib_rainwater_trapping {
    public int trap(final List<Integer> l) {
        int psum[]=new int[l.size()];
        for(int i=0;i<l.size();++i)
            psum[i]=i==0?l.get(i):psum[i-1]+l.get(i);
        int lmax[]=new int[l.size()];
        int rmax[]=new int[l.size()];
        int max=0;
        for(int i=0;i<l.size();++i){
            max=Math.max(max, l.get(i));
            lmax[i]=max;
        }

        max=0;
        for(int i=l.size()-1;i>=0;--i){
            max=Math.max(max, l.get(i));
            rmax[i]=max;
        }
        int ans=0;
        for(int i=0;i<l.size();++i){
            ans+=Math.min(rmax[i],lmax[i])-l.get(i);
        }
        return ans;
    }
}
