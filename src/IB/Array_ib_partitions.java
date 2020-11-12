package IB;
//https://www.interviewbit.com/problems/partitions/
//ref: https://www.geeksforgeeks.org/count-the-number-of-ways-to-divide-an-array-into-three-contiguous-parts-having-equal-sum/
public class Array_ib_partitions {
    public int solve(int a, int[] arr) {
        int sum=0;
        for(int x:arr)
            sum+=x;
        if(sum%3!=0) return 0;

        sum/=3;
        int c[]=new int[arr.length];
        int tsum=0;
        for(int i=arr.length-1;i>=0;--i){
            tsum+=arr[i];
            if(tsum==sum)
                c[i]=1;
        }

        for(int i=arr.length-2;i>=0;--i)
            c[i]=c[i+1]+c[i];

        tsum=0;
        int ans=0;
        for(int i=0;i<arr.length-2;++i){
            tsum+=arr[i];
            if(tsum==sum)
                ans+=c[i+2];
        }
        return ans;
    }
}
