package revision;

import java.util.*;
//https://practice.geeksforgeeks.org/problems/coin-piles/0
public class Greedy_gfg_coin_piles {
    public static void main (String[] args) {
        Scanner sc =new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            String s[]= sc.nextLine().split(" ");
            int len=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            String a[]=sc.nextLine().split(" ");
            int arr[]= new int[len];
            for(int i=0;i<len;++i)
                arr[i]=Integer.parseInt(a[i]);
            System.out.println(coinPiles(arr,k));
        }
    }

    public static int coinPiles(int arr[], int k){
        Arrays.sort(arr);
        int ans=Integer.MAX_VALUE;
        int psum=0;
        for(int i=0;i<arr.length;++i){
            int temp=psum;
            for(int j=0;j<arr.length;++j){
                if(arr[j]-arr[i]>k)
                    temp+=arr[j]-arr[i]-k;
            }
            ans=Math.min(ans,temp);
            psum+=arr[i];
        }
        return ans;
    }
}
