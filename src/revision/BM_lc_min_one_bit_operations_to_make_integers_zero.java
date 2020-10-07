package revision;

import java.util.*;
//https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/
public class BM_lc_min_one_bit_operations_to_make_integers_zero {
    public int minimumOneBitOperations(int n) {
        if(n==0) return 0;
        Deque<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(n,0));
        boolean visited[]=new boolean[n<<1];
        visited[n]=true;
        while(!q.isEmpty()){
            Pair p= q.pollFirst();
            if(p.n==0)
                return p.c;

            int x=p.n+((p.n&1)==1?-1:+1);
            if(x>=0 && x<(p.n<<1) && !visited[x]){
                q.add(new Pair(x,p.c+1));
                visited[x]=true;
            }

            int i=0;
            for(i=0;i<31;++i){
                if((p.n&(1<<i))!=0)
                    break;
            }
            if(i==31)
                continue;
            i++;

            x=p.n+((p.n&(1<<i))==(1<<i)?-(1<<i):+(1<<i));
            if(x>=0 && x<(p.n<<1) && !visited[x]){
                q.add(new Pair(x,p.c+1));
                visited[x]=true;
            }
        }
        return -1;
    }
    class Pair{
        int n;
        int c;
        public Pair(int a,int b){
            n=a;
            c=b;
        }
    }
}