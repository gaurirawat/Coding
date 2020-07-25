package revision;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem/0
public class Graph_gfg_snakes_and_ladder {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int x=Integer.parseInt(sc.nextLine());
            int g[]= new int[30];
            String[]s= sc.nextLine().split(" ");
            for(int i=0;i<s.length;i+=2)
                g[Integer.parseInt(s[i])-1]=Integer.parseInt(s[i+1])-1;
            System.out.println(snakesAndLadderBFS(g));
        }
    }

    public static int snakesAndLadderBFS(int[]g){
        int distance[]=new int[30];
        Deque<Integer> q= new LinkedList<Integer>();
        q.add(0);
        distance[0]=0;
        while(q.size()!=0){
            int x=q.pollFirst();
            if(x==29)
                break;
            for(int j=x+1;j<=x+6 && j<30;++j){
                if(distance[j]==0 && j!=0){
                    if(g[j]!=0){
                        q.addLast(g[j]);
                        distance[g[j]]=(distance[g[j]]!=0?Math.min(distance[g[j]],distance[x]+1):distance[x]+1);
                    }
                    else{
                        q.addLast(j);
                        distance[j]=distance[x]+1;
                    }
                }
            }
        }
        return distance[29];
    }

}
