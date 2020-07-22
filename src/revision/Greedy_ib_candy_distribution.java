package revision;
//https://leetcode.com/problems/candy/submissions/
//https://www.interviewbit.com/problems/distribute-candy/

import java.util.Arrays;
public class Greedy_ib_candy_distribution {
    public int candy(int[] a) {
        if(a==null||a.length<=1) return a.length;
        int candy[]= new int[a.length];
        Arrays.fill(candy,1);

        for(int i=1;i<a.length;++i)
            if(a[i]>a[i-1])
                candy[i]=candy[i-1]+1;

        for(int i=a.length-2;i>=0;--i)
            if(a[i]>a[i+1])
                candy[i]=Math.max(candy[i], 1+candy[i+1]);

        int sum=0;
        for(int i=0;i<a.length;++i){
            sum+=candy[i];
        }
        return sum;
    }
}
