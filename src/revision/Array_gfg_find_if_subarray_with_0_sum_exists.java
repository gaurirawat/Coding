package revision;

import java.util.*;
//https://practice.geeksforgeeks.org/problems/subarray-with-0-sum/0
//Ref:
//https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
public class Array_gfg_find_if_subarray_with_0_sum_exists {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int arr[]=new int[s.length];
            for(int i=0;i<arr.length;++i)
                arr[i]=Integer.parseInt(s[i]);
            System.out.println(isZeroSumPresent(arr)?"Yes":"No");
        }
    }

    public static boolean isZeroSumPresent(int arr[]){
        HashSet<Integer> set=new HashSet<Integer>();
        int sum=0;
        for(int x:arr){
            sum+=x;
            if(sum==0||set.contains(sum))return true;
            set.add(sum);
        }
        return false;
    }
}
