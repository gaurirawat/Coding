package revision;
//https://practice.geeksforgeeks.org/problems/minimum-platforms/0
import java.util.*;
public class Array_gfg_min_platforms {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=Integer.parseInt(sc.nextLine());
            String a[]= sc.nextLine().split(" ");
            String b[]=sc.nextLine().split(" ");
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(b));
            double s[]= new double[len];
            double e[]= new double[len];
            for(int i=0;i<len;++i){
                s[i]=Double.parseDouble(a[i].substring(0,2))+(Double.parseDouble(a[i].substring(2,4))/100);
                e[i]=Double.parseDouble(b[i].substring(0,2))+(Double.parseDouble(b[i].substring(2,4))/100);
            }
            System.out.println(findMinStations(s,e));
        }
    }

    public static int findMinStations(double s[], double e[]){
        Arrays.sort(s);
        Arrays.sort(e);
        int c=0, mxc=0, ss=0,ee=0;
        while(ss<s.length && ee<s.length){
            if(s[ss]<=e[ee]){
                c++;
                ss++;
            }
            else{
                c--;
                ee++;
            }
            mxc=Math.max(mxc,c);
        }
        return mxc;
    }
}
