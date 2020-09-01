package revision;

import java.util.Arrays;
import java.util.Scanner;

public class Rupeek {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int len=Integer.parseInt(sc.nextLine());
        long arr[]=new long[len];
        String s[]=sc.nextLine().split(" ");
        long xor=0;
        for(int i=0;i<len;++i) {
            arr[i] = Integer.toUnsignedLong(Integer.parseInt(s[i]));
            xor=xor^arr[i];
        }
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0;--i){
            System.out.println(Integer.toUnsignedLong((int)(~xor)));
            xor=xor^arr[i];
        }
    }
}

/*
5
4 7 18 16 14
4294967280
4294967266
4294967282
4294967292
4294967291
 */