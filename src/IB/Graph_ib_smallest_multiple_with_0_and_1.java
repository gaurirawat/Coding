package IB;

import java.util.*;

public class Graph_ib_smallest_multiple_with_0_and_1 {
    public String multiple(int n) {
        if(n==1) return "1";
        int curr=1;
        int state[]=new int[n];
        int parent[]=new int[n];
        Arrays.fill(state,-1);
        Arrays.fill(parent,-1);
        Deque<Integer> q=new LinkedList<Integer>();
        q.add(1);
        state[1]=1;
        while(!q.isEmpty()){
            curr=q.pollFirst();
            if(curr==0)
                break;
            int rem=(curr*10)%n;
            if(parent[rem]==-1){
                q.addLast(rem);
                parent[rem]=curr;
                state[rem]=0;
            }
            rem=(curr*10+1)%n;
            if(parent[rem]==-1){
                q.addLast(rem);
                parent[rem]=curr;
                state[rem]=1;
            }
        }

        StringBuffer sbr=new StringBuffer();
        curr=0;
        while(curr!=1){
            sbr.append(state[curr]+"");
            curr=parent[curr];
        }
        sbr.append("1");
        return sbr.reverse().toString();
    }
}
