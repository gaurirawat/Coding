package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/counting-triangles/

//very poor problem description
public class Pointer_ib_counting_triangles {
    public int nTriang(int[] arr) {
        Arrays.sort(arr);
        long c=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=arr.length-1;i>=0;--i){
            int l=0, r=i-1;
            while(l<r){
                if(arr[l]+arr[r]>arr[i]){
                    c+=r-l;
                    r--;
                }
                else
                    l++;
            }
            c=c%mod;
        }
        return (int)c;
    }
}
