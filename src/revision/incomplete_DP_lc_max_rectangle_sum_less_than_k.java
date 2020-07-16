package revision;

import java.util.Arrays;

public class incomplete_DP_lc_max_rectangle_sum_less_than_k {
    public int maxSumSubmatrix(int[][] arr, int k) {
        int r=arr.length;
        int c=arr[0].length;

        for(int i=0;i<r;++i){
            for(int j=0;j<c-1;++j){
                arr[i][j+1]=arr[i][j]+arr[i][j+1];
            }
        }
        int mxSum=0;
        for(int st=0;st<c;++st){
            for(int end=st;end<c;++end){
                //since the start and the end row are fixed we need to
                // apply kadanes vertically taking the valid row area of every
                //row as one cell
                int kCurrSum=0, kMaxSoFar=0, kSt=0;
                for(int i=0;i<r; ++i){
                    int cell= st==0? arr[i][end]: arr[i][end]-arr[i][st-1];
                    kCurrSum+=cell;

                    while(kCurrSum>k) {
                        kCurrSum = kCurrSum - (st == 0 ? arr[kSt][end] : arr[kSt][end] - arr[kSt][st - 1]);
                        kSt++;
                    }
                    if(kCurrSum>kMaxSoFar){
                        kMaxSoFar=kCurrSum;
                    }
                    if(kCurrSum<0){
                        kCurrSum=0;
                        kSt=i+1;
                    }
                }
                mxSum=Math.max(mxSum,kMaxSoFar);
            }
        }
        return mxSum;
    }
}
