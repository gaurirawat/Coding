package revision;
//https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
public class BitMasking_lc_max_no_of_achievable_transfer_requests {
    int max;
    public int maximumRequests(int n, int[][] req) {
        max=0;
        outer:for(int mask=1;mask<(1<<req.length);++mask){
            int bitCount=Integer.bitCount(mask);
            if(bitCount<=max) continue;

            int drr[]=new int[n];
            for(int num=mask,reqNo=0; num!=0 ;num=num>>1,reqNo++){
                if((num&1)==1){
                    drr[req[reqNo][0]]--;
                    drr[req[reqNo][1]]++;
                }
            }

            for(int i=0;i<n;++i)
                if(drr[i]!=0)
                    continue outer;
            max=Math.max(max, bitCount);
        }
        return max;
    }
}
