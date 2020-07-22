package revision;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/page-faults-in-lru/0
public class Greedy_gfg_max_LRU_page_faults {
    public static void main (String[] args) {
        Scanner sc =new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=Integer.parseInt(sc.nextLine());
            String a[]=sc.nextLine().split(" ");
            int arr[]= new int[len];
            for(int i=0;i<len;++i)
                arr[i]=Integer.parseInt(a[i]);
            int k=Integer.parseInt(sc.nextLine());
            System.out.println(LRUcache(arr,k));
        }
    }
    public static int LRUcache(int arr[], int k){
        Deque<Integer> q= new LinkedList<Integer>();
        int c=0;
        for(int i=0;i<arr.length;++i){
            if(q.contains(arr[i])){
                q.remove(arr[i]);
                q.addLast(arr[i]);
            }
            else if(q.size()==k){
                c++;
                q.pollFirst();
                q.addLast(arr[i]);
            }else{
                c++;
                q.addLast(arr[i]);
            }
        }
        return c;
    }
}
