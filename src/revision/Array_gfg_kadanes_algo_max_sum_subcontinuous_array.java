package revision;

//https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0

import java.util.Scanner;
public class Array_gfg_kadanes_algo_max_sum_subcontinuous_array {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=Integer.parseInt(sc.nextLine());
            String s[] = sc.nextLine().split(" ");
            int arr[]= new int[len];
            for(int i=0;i<len;++i)
                arr[i]=Integer.parseInt(s[i]);
            System.out.println(kadanesAlgo(arr));
        }
    }

    public static int kadanesAlgo(int arr[]){
        int csum=0, mxsum=0;
        int mx=arr[0];//max element. this shall be returned if mxsum=0
        for(int i=0;i<arr.length;++i){
            mx=Math.max(mx,arr[i]);
            csum+=arr[i];
            if(mxsum<csum)
                mxsum=csum;
            if(csum<0)
                csum=0;
        }
        if(mxsum==0)
            return mx;
        else
            return mxsum;
    }
}
