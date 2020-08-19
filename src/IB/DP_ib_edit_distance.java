package IB;
//https://www.interviewbit.com/problems/edit-distance/
public class DP_ib_edit_distance {
    public int minDistance(String a, String b) {
        char arr[]=a.toCharArray();
        char brr[]=b.toCharArray();
        int dp[][]=new int[arr.length][brr.length];
        return minDistDP(0,0,arr,brr,dp);
    }

    public int minDistDP(int i, int j, char a[], char b[], int dp[][]){
        if(i==a.length && j==b.length) return 0;
        if(i==a.length) return b.length-j;
        if(j==b.length) return a.length-i;
        if(dp[i][j]!=0) return dp[i][j];
        if(a[i]==b[j]) return minDistDP(i+1,j+1,a,b,dp);
        else
            dp[i][j]=Math.min(minDistDP(i+1,j,a,b,dp),Math.min(minDistDP(i+1,j+1,a,b,dp),minDistDP(i,j+1,a,b,dp)))+1;
        return dp[i][j];
    }
}
