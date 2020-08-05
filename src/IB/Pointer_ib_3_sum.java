package IB;

import java.util.Arrays;
//https://www.interviewbit.com/problems/3-sum/
public class Pointer_ib_3_sum {
    public int threeSumClosest(int[] a, int k) {
        long ans=Integer.MAX_VALUE;
        Arrays.sort(a);
        outer:for(int i=0;i<=a.length-2;++i){
            int l=i+1,r=a.length-1;
            long sum=k-a[i];
            while(l<r){
                long tsum=a[l]+a[r];
                if(Math.abs(ans-k)>Math.abs(tsum-sum))
                    ans=a[l]+a[r]+a[i];
                if(tsum==sum)
                    break outer;
                else if(tsum<sum)
                    ++l;
                else
                    --r;
            }
        }
        return (int)ans;
    }
}
