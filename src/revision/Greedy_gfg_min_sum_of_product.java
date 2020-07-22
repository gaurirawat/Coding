package revision;

import java.util.*;
//https://practice.geeksforgeeks.org/problems/minimize-the-sum-of-product/0
public class Greedy_gfg_min_sum_of_product {
    public static void main (String[] args) {
        Scanner sc =new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=Integer.parseInt(sc.nextLine());
            String s1[]=sc.nextLine().split(" ");
            String s2[]=sc.nextLine().split(" ");
            int a[]= new int[len];
            Integer b[]= new Integer[len];
            for(int i=0;i<len;++i){
                a[i]=Integer.parseInt(s1[i]);
                b[i]=Integer.parseInt(s2[i]);
            }
            System.out.println(minSumOfProducts(a,b));
        }
    }
    public static long minSumOfProducts(int a[], Integer b[]){
        Arrays.sort(a);
        Arrays.sort(b, Comparator.reverseOrder());
        long sum=0;
        for(int i=0;i<a.length;++i)
            sum+=(a[i]*b[i]);
        return sum;
    }
}
