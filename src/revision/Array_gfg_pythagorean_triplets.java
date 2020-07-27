package revision;

import java.util.*;
//https://practice.geeksforgeeks.org/problems/pythagorean-triplet/0
public class Array_gfg_pythagorean_triplets {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=sc.nextInt();
            int arr[]= new int[len];
            for(int i=0;i<arr.length;++i)
                arr[i]=sc.nextInt();
            System.out.println(doesPythagorianTripletExist(arr)?"Yes":"No");
        }
    }

    public static boolean doesPythagorianTripletExist(int[]arr){
        if(arr.length<=2) return false;
        Arrays.sort(arr);
        for(int i=2;i<arr.length;++i){
            int l=0, r=i-1;
            while(l<r){
                int value=arr[l]*arr[l]+arr[r]*arr[r]-arr[i]*arr[i];
                if(value==0)
                    return true;
                if(value>0)
                    --r;
                else
                    ++l;
            }
        }
        return false;
    }
}
