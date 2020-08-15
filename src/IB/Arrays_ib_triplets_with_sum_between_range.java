package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
public class Arrays_ib_triplets_with_sum_between_range {
    public int solve(String[] a) {
        double d[]=new double[a.length];
        for(int i=0;i<a.length;++i)
            d[i]=Double.parseDouble(a[i]);
        Arrays.sort(d);
        for(int i=0;i<d.length;++i){
            int l=i+1;
            int r=a.length-1;
            while(l<r){
                double tsum=d[l]+d[r]+d[i];
                if(1<tsum && tsum<2)
                    return 1;
                if(tsum>=2)
                    --r;
                else
                    ++l;
            }
        }
        return 0;
    }
}
