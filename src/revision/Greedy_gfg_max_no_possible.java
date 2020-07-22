package revision;
//https://practice.geeksforgeeks.org/problems/largest-number-possible/0
import java.util.Scanner;

public class Greedy_gfg_max_no_possible {
    public static void main (String[] args) {
        Scanner sc =new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            String s[]= sc.nextLine().split(" ");
            int d=Integer.parseInt(s[0]);
            int sum=Integer.parseInt(s[1]);
            System.out.println(maxPossibleNumber(d,sum));
        }
    }

    public static String maxPossibleNumber(int d, int sum){
        if(sum==0) return "-1";
        String ans="";
        while(d>1 && sum>9){
            sum-=9;
            ans+=9;
            --d;
        }
        while(d>0 && sum<=9){
            ans=ans+sum;
            sum-=sum;
            --d;
        }
        if(d==0 && sum==0)
            return ans;
        return "-1";
    }
}
