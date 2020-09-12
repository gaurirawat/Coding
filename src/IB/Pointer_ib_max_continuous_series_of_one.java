package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/max-continuous-series-of-1s/
public class Pointer_ib_max_continuous_series_of_one {
    public ArrayList<Integer> maxone(ArrayList<Integer> a, int k) {
        int ansl=0,ansr=a.size();
        for(int i=0;i<a.size();++i){
            if(a.get(i)==0){
                if(k==0){
                    ansr=i;
                    break;
                }
                --k;
            }
        }
        int l=0,r=ansr;
        while(r<a.size()){
            while(l<a.size()&&a.get(l)!=0)++l;
            ++l;
            ++r;
            while(r<a.size()&&a.get(r)!=0)++r;
            if(r<=a.size()&&ansr-ansl<r-l){
                ansl=l;
                ansr=r;
            }
        }
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=ansl;i<ansr;++i)
            ans.add(i);
        return ans;
    }
}