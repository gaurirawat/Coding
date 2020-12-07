package IB;

/*
This problem can be taken as the problem of dividing the array into k partitions such that the max sum of each partition
is minimized.
 */
//https://www.interviewbit.com/problems/painters-partition-problem/
public class BSearch_ib_painters_partition_problem {
    public int paint(int k, int t, int[] a) {
        int mod=(int)Math.pow(10,7)+3;
        int max=0;
        if(k>=a.length){
            for(int x:a)
                max=Math.max(max, x);
            return (int)((max*1l*t)%mod);
        }

        long min=Long.MAX_VALUE;
        long r=0;
        long l=0;
        for(int x:a){
            r+=x;
            l=Math.max(max,x);
        }

        while(l<=r){
            long mid=l+(r-l)/2;
            long val=getMaxSum(a,k,mid);
            //max value is returned whenever that particular sum is not possible. ie either any element is greater than
            // mid or overall more painters are being needed than the ones provided
            if(val==Long.MAX_VALUE)
                l=mid+1;
            else{
                min=Math.min(min,val);
                r=mid-1;
            }
        }
        return (int)((t*min)%mod);
    }

    public long getMaxSum(int a[],int k, long maxSum){
        long max=0;
        long sum=0;
        for(int i=0;i<a.length;++i){
            if(a[i]>maxSum)
                return Long.MAX_VALUE;
            if(sum+a[i]>maxSum){
                max=Math.max(max, sum);
                --k;
                if(k==0)
                    return Long.MAX_VALUE;
                sum=a[i];
            }
            else
                sum+=a[i];
        }
        max=Math.max(max, sum);
        return max;
    }
}
