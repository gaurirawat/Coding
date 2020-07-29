package revision;
//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
public class DP_lc_LCSubstring_max_length_of_repeated_subarray {
    public int findLength(int[] a, int[] b) {
        int la=a.length;
        int lb=b.length;
        int dp[][]= new int[la+1][lb+1];
        int max=0;
        for(int i=0;i< la;++i){
            for(int j=0;j< lb;++j){
                if(a[i]==b[j])
                    dp[i+1][j+1]=dp[i][j]+1;
                max=Math.max(dp[i+1][j+1], max);
            }
        }
        return max;
    }
}
