package revision;

import java.util.Deque;
import java.util.LinkedList;

public class A {

    public static void main(String[] args) {
        int p[] = {1, 2, 3, 4, 9, 8};
//        System.out.println(solve(6,p));
        System.out.println(stepsToZero(3));
        System.out.println(stepsToZero(6));
    }

    static int solve(int n, int[] p) {
        int dp[] = new int[n];
        int max = 0;
        for (int i = 0; i < p.length; ++i) {
            dp[i] = p[i];
            max = Math.max(max, dp[i]);
            for (int j = 0; j < i; ++j) {
                if (p[i] % p[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + p[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    static int stepsToZero(int a){
        if(a<=1) return a;
        Deque<Pair>q= new LinkedList<Pair>();
        q.add(new Pair(0,0));
        boolean visited[]=new boolean[a+1];
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            if(p.no==a)
                return p.c;
            if(p.no!=0){
                for(int i=2;i<=p.no;++i){
                    int num=p.no*i;
                    if(num<=a && !visited[num]){
                        visited[num]=true;
                        q.add(new Pair(num,p.c+1));}

                }
            }
            if(!visited[p.c+1]){
                visited[p.c+1]=true;
                q.add(new Pair(p.no+1,p.c+1));
            }

        }
        return 0;
    }
}

class Pair{
    int no;
    int c;
    public Pair(int no, int c){
        this.no=no;
        this.c=c;
    }
}
