package revision;
//https://practice.geeksforgeeks.org/problems/activity-selection/0
import java.util.*;
public class Greedy_gfg_activity_selection_start_end_time {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=Integer.parseInt(sc.nextLine());
            String[]s=sc.nextLine().split(" ");
            String[]e=sc.nextLine().split(" ");
            Activity a[]=new Activity[len];
            for(int i=0;i<len;++i){
                a[i]=new Activity(Integer.parseInt(s[i]),Integer.parseInt(e[i]));
            }
            System.out.println(maxNoOfActivityPossible(a));
        }
    }
    public static int maxNoOfActivityPossible(Activity a[]){
        Arrays.sort(a,Comparator.comparingInt(x->x.e));
        int c=1;
        Activity curr=a[0];
        for(int i=1;i<a.length;++i){
            if(a[i].s>=curr.e){
                curr=a[i];
                c++;
            }
        }
        return c;
    }
}
class Activity{
    int s,e;
    public Activity(int s,int e){
        this.s=s;
        this.e=e;
    }
}
