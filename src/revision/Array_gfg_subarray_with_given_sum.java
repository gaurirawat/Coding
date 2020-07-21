package revision;

import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

/*
this approach is possible only because the array contains positive numbers. Otherwise sliding window/two pointer would
not have worked
 */
public class Array_gfg_subarray_with_given_sum {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        while(t--!=0){
            String r[]= sc.nextLine().split(" ");
            int len=Integer.parseInt(r[0]);
            int k=Integer.parseInt(r[1]);
            String s[]= sc.nextLine().split(" ");
            int arr[]= new int[len];
            for(int i=0;i<len;++i){
                arr[i]=Integer.parseInt(s[i]);
            }
            System.out.println(doesSumExist(arr,k));
        }
    }

    public static String doesSumExist(int arr[], int k){
        int sum=0;
        int l=0,r=0;
        for(r=0;r<arr.length;++r){
            sum+=arr[r];
            while(sum>k)
                sum-=arr[l++];
            if(sum==k && l<=r)
                break;
        }
        return sum==k?(l+1+" "+(r+1)):"-1";
    }
}
