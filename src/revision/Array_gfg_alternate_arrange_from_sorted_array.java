package revision;

import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/
//https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/

public class Array_gfg_alternate_arrange_from_sorted_array {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=Integer.parseInt(sc.nextLine());
            String s[]= sc.nextLine().split(" ");
            long arr[]=new long[len];
            for(int i=0;i<len;++i)
                arr[i]=Long.parseLong(s[i]);
            alternate(arr);
            for(int i=0;i<arr.length;++i)
                System.out.print(arr[i]+ " ");
            System.out.println();
        }
    }

    public static void alternate(long[]arr){
        long mx=arr[arr.length-1]+1;
        int cmn=0;//counter starting from min
        int cmx=arr.length-1;//counter starting from max

        //put two elements on one cell
        for(int i=0;i<arr.length;++i){
            if(i%2==0){
                arr[i]+=(arr[cmx]%mx)*mx;
                cmx--;
            }
            else{
                arr[i]+=(arr[cmn]%mx)*mx;
                cmn++;
            }
        }

        //extract the required elements
        for(int i=0;i<arr.length;++i){
            arr[i]=arr[i]/mx;
        }
    }
}
