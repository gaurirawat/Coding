package revision;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/circle-of-strings/0
public class Tree_gfg_circle_of_string {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            sc.nextLine();
            String arr[]= sc.nextLine().split(" ");

            //create graph of these strings
            ArrayList<ArrayList<Integer>> g= new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<arr.length;++i){
                ArrayList<Integer> l= new ArrayList<Integer>();
                for(int j=0;j<arr.length;++j){
                    if(arr[i].charAt(arr[i].length()-1)==arr[j].charAt(0))
                        l.add(j);
                }
                g.add(l);
            }
            boolean visited[]= new boolean[g.size()];
            System.out.println(detectCircleOfString(0, g, visited, 0, 0)?1:0);
        }
    }

    public static boolean detectCircleOfString(int v,ArrayList<ArrayList<Integer>> g,
                                               boolean[]visited,int src, int c){
        visited[v]=true;
        for(int x:g.get(v)){
            if(x==src && c==visited.length-1)
                return true;
            if(!visited[x] && detectCircleOfString(x,g,visited,src,c+1))
                return true;
        }
        return false;
    }
}
