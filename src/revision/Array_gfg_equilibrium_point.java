package revision;

import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/equilibrium-point/0

public class Array_gfg_equilibrium_point {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=Integer.parseInt(sc.nextLine());
            String s[]= sc.nextLine().split(" ");
            int arr[]=new int[len];
            for(int i=0;i<len;++i)
                arr[i]=Integer.parseInt(s[i]);
            System.out.println(getEquilibriumPoint(arr));
        }
    }
    public static int getEquilibriumPoint(int[]arr){
        for(int i=0;i<arr.length-1;++i)
            arr[i+1]=arr[i]+arr[i+1];

        for(int i=0;i<arr.length;++i){
            int bef= i==0?0:arr[i-1];
            int aft= i==arr.length-1?0:arr[arr.length-1]-arr[i];
            if(bef==aft)
                return i+1;
        }
        return -1;
    }
}
