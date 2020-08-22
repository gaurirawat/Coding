package revision;

import java.util.HashMap;
import java.util.Scanner;

public class Tree_Google_OA {
    int max=Integer.MIN_VALUE;
    public int maxSum(TreeNode root){
        if(root==null) return 0;
        int l=maxSum(root.left);
        int r=maxSum(root.right);
        if(root.val+l+r>max)
            max=root.val+l+r;
        return Math.max(root.val, root.val+Math.max(l,r));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int n=Integer.parseInt(sc.nextLine());
            String s[]=sc.nextLine().split(" ");
            HashMap<Integer,GTree> map=new HashMap<Integer, GTree>();
            for(int i=0;i<n;++i){
                map.put(i+1,new GTree(Integer.parseInt(s[i])));
            }
            GTree root=map.get(1);
            for(int i=1;i<n;++i){
                String ss[]=sc.nextLine().split(" ");
                GTree par=map.get(Integer.parseInt(ss[0]));
                if(par.left==null)
                    par.left=map.get(Integer.parseInt(ss[0]));
                else
                    par.right=map.get(Integer.parseInt(ss[1]));
            }
        }
    }
}

class GTree{
    GTree left;
    GTree right;
    int val;
    public GTree(int x){
        val=x;
    }
}