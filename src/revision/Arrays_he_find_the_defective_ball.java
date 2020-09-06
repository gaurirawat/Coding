package revision;

import java.util.Scanner;

//https://www.hackerearth.com/problem/algorithm/balance-it-2-08745bd7/
public class Arrays_he_find_the_defective_ball {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        System.out.println(calc(t));
    }

    public static int calc(int n){
        if(n<=1) return 0;
        if(n<=3)return 1;
        if(n<=5) return 2;
        int rem=n%3;
        if(rem==0)
            return 1+calc(n/3);
        if(rem==1)
            return Math.max(1+calc(n/3),2);
        else
            return Math.max(1+calc(n/3),2);
    }
}
