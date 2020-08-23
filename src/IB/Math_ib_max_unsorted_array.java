package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/maximum-unsorted-subarray/
public class Math_ib_max_unsorted_array {
    public int[] subUnsort(int[] arr) {
        int crr[]= Arrays.copyOf(arr, arr.length);
        Arrays.sort(crr);

        // System.out.println(Arrays.toString(crr));
        int i=0;
        for(i=0;i<arr.length;++i){
            if(arr[i]!=crr[i])
                break;
        }

        if(arr.length==0||i==arr.length){
            int res[]=new int[1];
            res[0]=-1;
            return res;
        }

        int res[]=new int[2];
        res[0]=i;
        for(i=arr.length-1;i>=0;--i){
            if(arr[i]!=crr[i])
                break;
        }
        res[1]=i;
        return res;
    }
}
