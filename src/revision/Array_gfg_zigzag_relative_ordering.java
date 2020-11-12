package revision;

import java.util.*;
//https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/0
/*
    void zigZag(int arr[], int n) {
        boolean lessThan=true;
        for(int i=0;i<arr.length-1;++i){
            if(lessThan && arr[i]>arr[i+1]) swap(arr,i);
            if(!lessThan && arr[i]<arr[i+1]) swap(arr,i);
            lessThan=!lessThan;
        }
    }

    void swap(int arr[], int i){
        int t=arr[i];
        arr[i]=arr[i+1];
        arr[i+1]=t;
    }
 */
public class Array_gfg_zigzag_relative_ordering {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=sc.nextInt();
            int arr[]= new int[len];
            for(int i=0;i<arr.length;++i)
                arr[i]=sc.nextInt();
            zigzagArray(arr);
            for(int i=0;i<arr.length;++i)
                System.out.print(arr[i]+ " ");
            System.out.println();
        }
    }

    public static void zigzagArray(int arr[]){
        if(arr.length<=2){
            Arrays.sort(arr);
            return;
        }
        for(int i=0;i<arr.length-1;i+=2){
            if(i==arr.length-2){
                int a=arr[i], b=arr[i+1];
                if(i%2==0 && a>b){
                    arr[i]=b;
                    arr[i+1]=a;
                }
                else if(i%2==1 && a<b){
                    arr[i]=b;
                    arr[i+1]=a;
                }
            }
            else if(i%2==0){
                int a=arr[i], b=arr[i+1], c=arr[i+2];
                if(a<b){
                    if(b<c){
                        arr[i+1]=c;
                        arr[i+2]=b;
                    }
                }
                else{
                    if(b>c){
                        arr[i]=b;
                        arr[i+1]=a;
                    }
                    else{
                        arr[i]=b;
                        arr[i+1]=a>c?a:c;
                        arr[i+2]=a>c?c:a;
                    }
                }
            }
            else{
                int a=arr[i], b=arr[i+1], c=arr[i+2];
                if(a>b){
                    if(b>c){
                        arr[i+1]=c;
                        arr[i+2]=b;
                    }
                }
                else{
                    if(b<c){
                        arr[i]=b;
                        arr[i+1]=a;
                    }
                    else{
                        arr[i]=b;
                        arr[i+1]=a<c?a:c;
                        arr[i+2]=a<c?c:a;
                    }
                }

            }
        }
    }
}
