package IB;

import java.util.Arrays;

//interviewbit.com/problems/woodcutting-made-easy/
public class BSearch_ib_wood_cutting_made_easy {
    public int solve(int[] a, int target) {
        Arrays.sort(a);
        int l=0;
        int r=a[a.length-1];
        int max=0;
        while(l<=r) {
            int mid=l+(r-l)/2;
            long wood=getWoodCut(a, mid);
            if(wood>=target){
                max=mid;
                l=mid+1;
            }
            else {
                r=mid-1;
            }
        }
        return max;
    }

    public long getWoodCut(int[] a, int mid){
        long wood=0;
        for(int i=a.length-1; i>=0&&a[i]>=mid ; --i){
            wood+=a[i]-mid;
        }
        return wood;
    }
}