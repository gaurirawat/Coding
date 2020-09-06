package revision;

import java.util.Scanner;

//https://www.hackerearth.com/problem/algorithm/minmax-2-7a1ffa10/
public class Tree_he_min_and_max_numbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0) {
            long n = Long.parseLong(sc.nextLine());
            long temp = n;
            long x = (long) Math.floor(Math.log10(n) / Math.log10(2));
            while (x != 0 && temp != Math.pow(2, x)) {
                temp = temp - (long) Math.pow(2, x);
                x = (long) Math.floor(Math.log10(temp) / Math.log10(2));
            }
            if (x == 0)
                System.out.println(n + " " + n);
            else
                System.out.println((long)(n - Math.pow(2, x) + 1) + " " + (long)(n + Math.pow(2, x) - 1));
        }
    }

}
