package IB;
//https://www.interviewbit.com/problems/min-jumps-array/
public class DP_ib_min_jumps_in_array {
    public int jump(int[] arr) {
        if(arr.length<=1) return 0;
        if(arr[0]==0) return -1;

        int mxReach=arr[0], steps=arr[0], jumps=1;
        for(int i=1;i<arr.length;++i){
            if(i==arr.length-1)
                return jumps;
            mxReach= Math.max(mxReach, arr[i]+i);
            steps--;
            if(steps==0){
                jumps++;
                if(i==mxReach)
                    return -1;
                steps=mxReach-i;
            }
        }
        return -1;
    }
}