package revision;
//https://practice.geeksforgeeks.org/problems/cutted-segments/0

import java.util.Arrays;
import java.util.Scanner;

public class DP_gfg_max_cut_segments {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t--!=0){
            int len=sc.nextInt();
            int x=3;//since according to the question possible length are 3
            int arr[]= new int[x];
            for(int i=0; i< x;++i)
                arr[i]=sc.nextInt();
            int dp[]= new int[len+1];
            Arrays.fill(dp,-999);
            int p= maximumCutSegmentsDP(arr,dp,len);
            // we need to add 1 since the dp function returns us the max no of partitions. Segments=1+partition
            System.out.println(p+1);
        }
    }

    /*here for un-calculated length the cell contains -999. If the length is calculated but not valid ie length is 3
    but 3 is not given as a valid length then val shall be -1. Otherwise dp[i] contains the max no of partitions
    possible with the length i
     */
    public static int maximumCutSegmentsDP(int[]arr, int[]dp, int len){
        if(len<0) return -1; //invalid partition
        if(len==0) return 0;
        if(dp[len]!=-999) return dp[len];//not calculated before

        int val= -1;

        for(int i=0;i<arr.length;++i){
            if(len==arr[i])
                val= Math.max(val,0);//no partition possible but valid length
            if(len>arr[i]){
                int x=maximumCutSegmentsDP(arr,dp,arr[i]);
                int y=maximumCutSegmentsDP(arr,dp,len-arr[i]);
                if(x!=-1 && y!=-1)//both partions are valid
                    val=Math.max(val, x+y+1);
            }
        }
        dp[len]=val;
        return dp[len];
    }
}


















