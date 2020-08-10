package IB;

import java.util.ArrayList;
import java.util.Scanner;

public class Nutanix {
    static long tot;
    static int r;
    static int c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        int v = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);
        r = Integer.parseInt(s[3]);
        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < e; ++i)
            g.add(new ArrayList<Integer>());
        for (int i = 0; i < e; ++i) {
            String a[] = sc.nextLine().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            g.get(x).add(y);
            g.get(y).add(x);
        }

        tot = c * e;
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; ++i) {
            if (!visited[i]) {
                DFS(i, g, visited, 1);
            }

        }
        System.out.println(tot);
    }


    public static void DFS(int v, ArrayList<ArrayList<Integer>> g, boolean visited[], int nodes){
        visited[v]=true;

        for(int x:g.get(v)){
            if(visited[x] && (nodes*r+c)>(nodes+1)*c){

            }
        }
    }
}
