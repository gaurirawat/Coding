package revision;

//https://practice.geeksforgeeks.org/problems/maximize-toys/0

import java.util.*;
public class Greedy_gfg_maximize_toys {
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
            System.out.println(maxToys(arr,k));
        }
    }

    public static int maxToys(int arr[], int k){
        Arrays.sort(arr);
        int c=0;
        int i=0;
        while(k!=0 && i!=arr.length){
            if(arr[i]<=k){
                k-=arr[i];
                c++;
            }
            i++;
        }
        return c;
    }
}
