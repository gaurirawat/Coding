package revision;

import java.util.*;

public class Flipkart_juice {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String a[]=sc.nextLine().split(" ");
        String b[]=sc.nextLine().split(" ");
        int dis[]=new int[n];
        int juice[]=new int[n];
        ArrayList<Pair> l = new ArrayList<Pair>();
        for(int i=0;i<n;++i)
            l.add (new Pair(Integer.parseInt(a[i]),Integer.parseInt(b[i])));
        Collections.sort(l, Comparator.comparingInt(e->e.dis));

        for(int i=0;i<n;++i){
            dis[i]=l.get(i).dis;
            juice[i]=l.get(i).juice;
        }
        String c[]=sc.nextLine().split(" ");
        int d=Integer.parseInt(c[0]);
        int k=Integer.parseInt(c[1]);
        int dp[][]=new int[d+1][d+1];
        System.out.println(calc(dis, juice,d,0,k,dp));
    }

    public static int calc(int[]dis ,int[]juice, int D, int d, int j, int dp[][]){
        if(d+j>=D)
            return 0;
        if(dp[d][j]!=0) return dp[d][j];
        int c=Integer.MAX_VALUE;
        int pos= Arrays.binarySearch(dis,d+j);
        if(pos<0)
            pos=Math.abs(pos+1);
        if(pos==dis.length)
            pos--;
        for(;pos>=0 && dis[pos]>d;--pos ){
            int newj=j+juice[pos]-(dis[pos]-d);
            int temp=calc(dis, juice, D, dis[pos], newj,dp);
            if(temp!=-1)
                c=Math.min(c,1+temp);

        }
        dp[d][j]=c==Integer.MAX_VALUE?-1:c;
        return dp[d][j];
    }
}

class Pair{
    int dis;
    int juice;
    public Pair(int i, int j){
        dis=i;
        juice=j;
    }
}

/*
3
5 7 10
2 3 5
15 5


5
10 20 22 23 26
10 2 5 1 1
30 10
 */

//        System.out.println(Arrays.toString(dis));
//                System.out.println(Arrays.toString(juice));
//                System.out.println(d+" "+k);
//                System.out.println(calc(dis, juice,d,0,k,dp));
