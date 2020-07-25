package revision;
//https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
import java.util.ArrayList;

public class Tree_gfg_connect_nodes_at_same_level {

    public static void connect(Node p)
    {
        if(p==null) return;
        ArrayList<Node> ls =new ArrayList<Node>();
        connectInner(p,1,ls);
    }

    public static void connectInner(Node root,int ht, ArrayList<Node> ls){
        if(root==null) return;
        if(ht>ls.size())
            ls.add(root);
        else{
            root.nextRight=ls.get(ht-1);
            ls.set(ht-1,root);
        }
        connectInner(root.right,ht+1,ls);
        connectInner(root.left,ht+1,ls);
    }
    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
}
